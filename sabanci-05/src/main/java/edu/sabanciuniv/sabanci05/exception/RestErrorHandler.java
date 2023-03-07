package edu.sabanciuniv.sabanci05.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<BookApiExceptionTemplate> handleException(UnauthorizedException e) {
        BookApiExceptionTemplate template = getBookApiExceptionTemplate(e.getMessage(), HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(template, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BookApiExceptionTemplate> handleException(IllegalArgumentException e) {
        BookApiExceptionTemplate template = getBookApiExceptionTemplate(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(template, HttpStatus.BAD_REQUEST);
    }

    private BookApiExceptionTemplate getBookApiExceptionTemplate(String message, HttpStatus status) {
        BookApiExceptionTemplate template = new BookApiExceptionTemplate();
        template.setExceptionMessage(message);
        template.setStatusCode(status.value());
        template.setExceptionDate(LocalDateTime.now());
        return template;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class BookApiExceptionTemplate {
        private int statusCode;
        private String exceptionMessage;
        private LocalDateTime exceptionDate;
    }
}
