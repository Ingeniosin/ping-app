package cloud.juancamp.aws.tasks;

import cloud.juancamp.aws.enums.SystemStatus;
import cloud.juancamp.aws.utils.Context;
import cloud.juancamp.aws.utils.task.Task;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class SystemStatusTask implements Task<SystemStatus> {
    @SneakyThrows
    @Override
    public SystemStatus execute(Context context) {
        return SystemStatus.ACTIVE;
    }
}
