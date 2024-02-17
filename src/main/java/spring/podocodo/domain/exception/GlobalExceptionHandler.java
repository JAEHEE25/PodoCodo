package spring.podocodo.domain.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spring.podocodo.domain.constants.ExceptionCode;
import spring.podocodo.domain.dto.response.ExceptionResponseDto;
import spring.podocodo.domain.response.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValid(BindingResult bindingResult) {
        ExceptionResponseDto responseBody = ExceptionResponseDto.of(bindingResult);
        ExceptionResponse response = ExceptionResponse.from(ExceptionCode.INVALID_REQUEST, responseBody);
        return ResponseEntity.status(ExceptionCode.INVALID_REQUEST.getStatus()).body(response);
    }
}
