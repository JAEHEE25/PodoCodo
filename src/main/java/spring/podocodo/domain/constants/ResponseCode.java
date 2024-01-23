package spring.podocodo.domain.constants;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {
    USER_SAVE(HttpStatus.CREATED, "사용자 가입 성공!");

    private final HttpStatus status;
    private final String message;

    ResponseCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
