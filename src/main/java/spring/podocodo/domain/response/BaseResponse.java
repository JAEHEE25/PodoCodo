package spring.podocodo.domain.response;

import lombok.Builder;
import lombok.Getter;
import spring.podocodo.domain.constants.ResponseCode;

@Getter
@Builder
public class BaseResponse {
    private int status;
    private String message;
    private Object data;

    public static BaseResponse from(ResponseCode responseCode, Object data) {
        return BaseResponse.builder()
                .status(responseCode.getStatus().value())
                .message(responseCode.getMessage())
                .data(data)
                .build();
    }
}
