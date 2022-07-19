package luiz.augusto.Bookstoreapi.controllers.exception;

import luiz.augusto.Bookstoreapi.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StandardError> objectNotFoundException(
            ObjectNotFoundException e, ServletRequest s)
    {
        var error = new StandardError(e.getMessage(), System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
