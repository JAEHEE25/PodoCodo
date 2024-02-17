package spring.podocodo.domain.response;

import lombok.Builder;
import lombok.Getter;
import spring.podocodo.domain.constants.ExceptionCode;

@Getter
@Builder
public class ExceptionResponse {
    private int status;
    private String message;
    private Object data;

    public static ExceptionResponse from(ExceptionCode exceptionCode, Object data) {
        return ExceptionResponse.builder()
                .status(exceptionCode.getStatus().value())
                .message(exceptionCode.getMessage())
                .data(data)
                .build();
    }
}
