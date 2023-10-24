package cloud.juancamp.aws.utils.task;

import cloud.juancamp.aws.utils.Context;
import cloud.juancamp.aws.utils.Marshaller;
import cloud.juancamp.aws.utils.task.cache.TaskCacheItem;
import cloud.juancamp.aws.utils.task.cache.TaskContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TaskManager {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public static String getTaskField(final String name) {
        final String finalName = name.replace("Task", "");
        return finalName.substring(0, 1).toLowerCase() + finalName.substring(1);
    }

    public Map<String, Object> executeTasks(Context context, List<Task<?>> tasks) {
        final Stream<Task<?>> taskStream = tasks.stream().parallel();

        return taskStream
                .map(task -> executeTask(context, task))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map.Entry<String, Object> executeTask(Context context, Task<?> task) {
        final String taskField = getTaskField(task.getClass().getSimpleName());
        final TaskContext taskContext = context.getTaskContext();
        final Map<String, TaskCacheItem> taskCache = taskContext.getTaskCache();

        if (taskCache.containsKey(taskField)) {
            return taskCache.get(taskField).getEntry();
        }

        final TaskCacheItem taskCacheItem = new TaskCacheItem();
        taskCache.put(taskField, taskCacheItem);

        final Map.Entry<String, Object> result = Map.entry(taskField, task.execute(context));
        taskCacheItem.setEntry(result);

        return result;
    }

    public <T> T executeTasks(Context context, Class<T> clazz, List<Task<?>> tasks) {
        return objectMapper.convertValue(executeTasks(context, tasks), clazz);
    }

    public <TOut, TIn> TOut executeTasks(Context context, Marshaller<TIn, TOut> marshaller, List<Task<?>> tasks) {
        return marshaller.marshall(executeTasks(context, marshaller.getInputClass(), tasks));
    }
}
