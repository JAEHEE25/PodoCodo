package spring.podocodo.domain.exception;

import lombok.Getter;
import spring.podocodo.domain.constants.ExceptionCode;

@Getter
public class CustomException extends RuntimeException {
    private final ExceptionCode exceptionCode;

    public CustomException(ExceptionCode exceptionCode){
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
