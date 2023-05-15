package br.com.ada.f1rst.pokebattle.model;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ApiExceptionTest {

    @Test
    void handlesStatusOnly() {
        ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST);

        assertEquals(HttpStatus.BAD_REQUEST.value(), apiException.getStatusCode());
        assertEquals(HttpStatus.BAD_REQUEST.getReasonPhrase(), apiException.getMessage());
    }

    @Test
    void handlesStatusAndMessage() {
        ApiException apiException = new ApiException(HttpStatus.BAD_GATEWAY, "Custom message!");

        assertEquals(HttpStatus.BAD_GATEWAY.value(), apiException.getStatusCode());
        assertEquals("Custom message!", apiException.getMessage());
    }
}
