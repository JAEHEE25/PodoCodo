package spring.podocodo.domain.response;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import spring.podocodo.domain.constants.ExceptionCode;

@Getter
@Builder
public class ExceptionResponse {
    private int status;
    private String message;

    @Nullable
    private Object data;

    public static ExceptionResponse from(ExceptionCode exceptionCode, @Nullable Object data) {
        return ExceptionResponse.builder()
                .status(exceptionCode.getStatus().value())
                .message(exceptionCode.getMessage())
                .data(data)
                .build();
    }
}
