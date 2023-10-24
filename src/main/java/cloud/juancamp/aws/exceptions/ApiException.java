package cloud.juancamp.aws.exceptions;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ApiException extends RuntimeException {
    private final String message;
    private final HttpStatus status;
    private String displayMessage;
    private String errorCode;
}
