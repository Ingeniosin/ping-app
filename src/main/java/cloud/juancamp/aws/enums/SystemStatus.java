package cloud.juancamp.aws.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SystemStatus {

    @JsonProperty("active") ACTIVE,
    @JsonProperty("inactive") INACTIVE,
    @JsonProperty("unknown") UNKNOWN

}
