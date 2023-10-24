package cloud.juancamp.aws.handlers;

import cloud.juancamp.aws.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleConflict(Exception exception) {
        final ExceptionDTO exceptionDTO = new ExceptionDTO(exception);
        return new ResponseEntity<>(exceptionDTO, HttpStatusCode.valueOf(exceptionDTO.getStatus()));
    }
}
