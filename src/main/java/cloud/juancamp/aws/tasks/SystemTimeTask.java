package cloud.juancamp.aws.tasks;

import cloud.juancamp.aws.model.SystemTimeModel;
import cloud.juancamp.aws.utils.Context;
import cloud.juancamp.aws.utils.task.Task;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.TimeZone;

@Component
public class SystemTimeTask implements Task<SystemTimeModel> {
    @SneakyThrows
    @Override
    public SystemTimeModel execute(Context context) {
        return new SystemTimeModel(
                System.currentTimeMillis(),
                new Date(),
                TimeZone.getDefault(),
                new Date(System.currentTimeMillis())
        );
    }
}
