package cloud.juancamp.aws.utils.task.cache;

import cloud.juancamp.aws.utils.task.Task;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static cloud.juancamp.aws.utils.task.TaskManager.getTaskField;

public class TaskContext {
    @Getter
    private final Map<String, TaskCacheItem> taskCache = new ConcurrentHashMap<>();
    private final Map<String, Map<String, Object>> taskParams = new ConcurrentHashMap<>();

    public void addParam(Class<?> clazz, String paramKey, Object value) {
        final String key = getTaskField(clazz.getSimpleName()).toLowerCase();
        taskParams.computeIfAbsent(key, k -> new ConcurrentHashMap<>()).put(paramKey, value);
    }

    public Optional<Object> getParam(Task<?> task, String paramKey) {
        return this.getParam(task.getClass(), paramKey);
    }

    public Optional<Object> getParam(Class<?> clazz, String paramKey) {
        final String key = getTaskField(clazz.getSimpleName()).toLowerCase();
        final Object value = taskParams.getOrDefault(key, new ConcurrentHashMap<>()).getOrDefault(paramKey, null);
        return Optional.ofNullable(value);
    }
}
