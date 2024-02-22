package spring.podocodo.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class ExceptionResponseDto {
    private List<ErrorField> errors;

    public static ExceptionResponseDto of(BindingResult bindingResult) {
        return ExceptionResponseDto.builder()
                .errors(ErrorField.of(bindingResult))
                .build();
    }

    @Builder
    @Getter
    private static class ErrorField {
        private String field;
        private String message;

        public static List<ErrorField> of(BindingResult bindingResult) {
            return bindingResult.getFieldErrors().stream().map(ErrorField::getInstance).collect(Collectors.toList());
        }

        private static ErrorField getInstance(FieldError error) {
            return ErrorField.builder()
                    .field(error.getField())
                    .message(error.getDefaultMessage())
                    .build();
        }
    }
}
