package yanghgri.pinksheep.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import yanghgri.pinksheep.enums.StatusCode;


@RestControllerAdvice("yanghgri.pinksheep.controller")
public class GenericResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // 判断返回值属于GenericResponse类，若属于，没必要再封装
        return !returnType.getGenericParameterType().equals(GenericResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            try {
                return objectMapper.writeValueAsString(body);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return new GenericResponse(StatusCode.OK.name(), StatusCode.OK.getCode(), body);
    }

    @ExceptionHandler(GenericException.class)
    public GenericResponse handleGenericException(GenericException e) {
        return new GenericResponse(e.getMessage(), e.getStatusCode(), null);
    }
}