package cloud.juancamp.aws.tasks;

import cloud.juancamp.aws.model.SystemPerformanceModel;
import cloud.juancamp.aws.utils.Context;
import cloud.juancamp.aws.utils.task.Task;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class SystemPerformanceTask implements Task<SystemPerformanceModel> {
    @SneakyThrows
    @Override
    public SystemPerformanceModel execute(Context context) {

        return new SystemPerformanceModel(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().freeMemory(),
                Runtime.getRuntime().maxMemory(),
                Runtime.getRuntime().totalMemory()
        );
    }
}
