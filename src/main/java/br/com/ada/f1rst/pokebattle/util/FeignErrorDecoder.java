package br.com.ada.f1rst.pokebattle.util;

import br.com.ada.f1rst.pokebattle.model.ApiException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return new ApiException(HttpStatus.valueOf(response.status()));
    }
}
