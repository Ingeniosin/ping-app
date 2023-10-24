package cloud.juancamp.aws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.TimeZone;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemTimeModel {

    private long time;
    private Date currentDate;
    private TimeZone currentTimeZone;
    private Date upTime;


}
