package cloud.juancamp.aws.dto.response;

import cloud.juancamp.aws.exceptions.ApiException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ExceptionDTO {

    private Integer status;
    private String message;
    private String displayMessage;
    private String errorCode;
    private String stackTrace;

    public ExceptionDTO(Exception exception) {
        this.message = exception.getMessage();
        this.stackTrace = ExceptionUtils.getStackTrace(exception);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.errorCode = HttpStatus.INTERNAL_SERVER_ERROR.name().toLowerCase();
        this.displayMessage = "Ocurrió un error inesperado.";

        if (exception instanceof ApiException apiException) {
            this.status = apiException.getStatus().value();
            this.message = apiException.getMessage();
            this.errorCode = Optional.ofNullable(apiException.getErrorCode()).orElse(apiException.getStatus().name()).toLowerCase();
            this.displayMessage = Optional.ofNullable(apiException.getDisplayMessage()).orElse(this.displayMessage);
        }

        exception.printStackTrace();
    }
}
