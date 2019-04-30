package bartboersma.springsecuritytryout.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleException(BadCredentialsException e) {
        log.error("BadCredentialsException: {}. Stacktrace: {}", e.getMessage(), e.getStackTrace());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Bad Credentials");
    }
}


