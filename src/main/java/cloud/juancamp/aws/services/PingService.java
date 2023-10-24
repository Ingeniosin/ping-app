package cloud.juancamp.aws.services;

import cloud.juancamp.aws.dto.response.PingInformationDTO;
import cloud.juancamp.aws.marshaller.PingInformationMarshaller;
import cloud.juancamp.aws.tasks.*;
import cloud.juancamp.aws.utils.Context;
import cloud.juancamp.aws.utils.task.TaskManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PingService {
    private final TaskManager taskManager;

    private final PingInformationMarshaller pingInformationMarshaller;

    private final SystemPerformanceTask systemPerformanceTask;
    private final SystemStatusTask systemStatusTask;
    private final PingMessageTask pingMessageTask;
    private final SystemInformationTask systemInformationTask;
    private final SystemTimeTask systemTimeTask;

    public PingService(
            PingInformationMarshaller pingInformationMarshaller,
            TaskManager taskManager,
            SystemPerformanceTask systemPerformanceTask,
            SystemStatusTask systemStatusTask,
            PingMessageTask pingMessageTask,
            SystemInformationTask systemInformationTask,
            SystemTimeTask systemTimeTask
    ) {
        this.pingInformationMarshaller = pingInformationMarshaller;
        this.taskManager = taskManager;
        this.systemPerformanceTask = systemPerformanceTask;
        this.systemStatusTask = systemStatusTask;
        this.pingMessageTask = pingMessageTask;
        this.systemInformationTask = systemInformationTask;
        this.systemTimeTask = systemTimeTask;
    }

    public PingInformationDTO getPingInformation(Context context) {
        return taskManager.executeTasks(context, pingInformationMarshaller, List.of(
                systemPerformanceTask,
                systemStatusTask,
                pingMessageTask,
                systemInformationTask,
                systemTimeTask
        ));
    }
}