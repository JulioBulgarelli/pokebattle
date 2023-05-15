package br.com.ada.f1rst.pokebattle.util;

import br.com.ada.f1rst.pokebattle.model.ApiException;
import br.com.ada.f1rst.pokebattle.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ErrorResponse handleException(
        Exception exception,
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse
    ) {
        Integer statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

        if (exception instanceof ApiException) {
            ApiException apiException = (ApiException) exception;
            statusCode = apiException.getStatusCode();
            message = apiException.getMessage();
        }

        httpServletResponse.setStatus(statusCode);

        return ErrorResponse.builder()
            .statusCode(statusCode)
            .message(message)
            .timestamp(OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
        .build();
    }
}
