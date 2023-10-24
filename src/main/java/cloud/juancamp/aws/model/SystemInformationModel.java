package cloud.juancamp.aws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemInformationModel {
    private String osName;
    private String osVersion;
    private String osArch;
    private String userName;
}
