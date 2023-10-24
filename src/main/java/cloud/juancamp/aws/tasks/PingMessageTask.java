package cloud.juancamp.aws.tasks;

import cloud.juancamp.aws.utils.Context;
import cloud.juancamp.aws.utils.task.Task;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
public class PingMessageTask implements Task<String> {
    private int count = 0;

    @SneakyThrows
    @Override
    public String execute(Context context) {
        return count++ + " - Pong";
    }
}
