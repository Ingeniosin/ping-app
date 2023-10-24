package cloud.juancamp.aws.model;

import cloud.juancamp.aws.enums.SystemStatus;
import lombok.Data;

@Data
public class PingInformationModel {
    private SystemPerformanceModel systemPerformance;
    private SystemInformationModel systemInformation;
    private SystemStatus systemStatus;
    private String pingMessage;
    private SystemTimeModel systemTime;
}
