package cloud.juancamp.aws.dto.response;

import cloud.juancamp.aws.enums.SystemStatus;
import cloud.juancamp.aws.model.SystemInformationModel;
import cloud.juancamp.aws.model.SystemPerformanceModel;
import cloud.juancamp.aws.model.SystemTimeModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PingInformationDTO {
    private String message;
    private SystemDetailsDTO details;

    public void setDetails(SystemInformationModel information, SystemPerformanceModel performance, SystemTimeModel time, SystemStatus status) {
        this.details = new SystemDetailsDTO(information, performance, time, status);
    }

    @Data
    @AllArgsConstructor
    public static class SystemDetailsDTO {
        private SystemInformationModel information;
        private SystemPerformanceModel performance;
        private SystemTimeModel time;
        private SystemStatus status;
    }
}
