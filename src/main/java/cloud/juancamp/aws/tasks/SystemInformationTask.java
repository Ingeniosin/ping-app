package cloud.juancamp.aws.tasks;

import cloud.juancamp.aws.model.SystemInformationModel;
import cloud.juancamp.aws.utils.Context;
import cloud.juancamp.aws.utils.task.Task;
import cloud.juancamp.aws.utils.task.TaskManager;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class SystemInformationTask implements Task<SystemInformationModel> {
    private final TaskManager taskManager;
    private final PingMessageTask pingMessageTask;

    public SystemInformationTask(TaskManager taskManager, PingMessageTask pingMessageTask) {
        this.taskManager = taskManager;
        this.pingMessageTask = pingMessageTask;
    }

    @SneakyThrows
    @Override
    public SystemInformationModel execute(Context context) {
        final String pingMessage = taskManager.executeTask(context, pingMessageTask).getValue().toString();
        return new SystemInformationModel(
                pingMessage,
                System.getProperty("os.name"),
                System.getProperty("os.arch"),
                System.getProperty("user.name")
        );
    }
}
