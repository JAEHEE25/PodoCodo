package spring.podocodo.domain.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.podocodo.domain.constants.ExceptionCode;
import spring.podocodo.domain.dto.response.ExceptionResponseDto;
import spring.podocodo.domain.response.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ExceptionResponseDto responseBody = ExceptionResponseDto.of(e.getBindingResult());
        ExceptionResponse response = ExceptionResponse.from(ExceptionCode.INVALID_REQUEST, responseBody);
        return ResponseEntity.status(ExceptionCode.INVALID_REQUEST.getStatus()).body(response);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleCustomException(CustomException e) {
        ExceptionResponse response = ExceptionResponse.from(ExceptionCode.EMAIL_DUPLICATION, null);
        return ResponseEntity.status(ExceptionCode.EMAIL_DUPLICATION.getStatus()).body(response);
    }
}
