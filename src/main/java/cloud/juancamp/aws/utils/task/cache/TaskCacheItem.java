package cloud.juancamp.aws.utils.task.cache;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.Map;

@Data
public class TaskCacheItem {
    private Map.Entry<String, Object> entry;
    private TaskCacheItemStatus status = TaskCacheItemStatus.PENDING;

    @SneakyThrows
    public synchronized Map.Entry<String, Object> getEntry() {
        if (status == TaskCacheItemStatus.PENDING) {
            this.wait();
        }
        return entry;
    }

    public synchronized void setEntry(Map.Entry<String, Object> entry) {
        this.entry = entry;
        this.status = TaskCacheItemStatus.DONE;
        this.notifyAll();
    }
}
