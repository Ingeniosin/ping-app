package cloud.juancamp.aws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemPerformanceModel {
    private Integer availableProcessors;
    private Long freeMemory;
    private Long maxMemory;
    private Long totalMemory;
}