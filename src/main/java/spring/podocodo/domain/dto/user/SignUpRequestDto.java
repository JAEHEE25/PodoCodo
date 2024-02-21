package spring.podocodo.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.podocodo.domain.entity.User;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    private static final int NAME_MAX_SIZE = 10;
    private static final int PASSWORD_MIN_SIZE = 8;
    private static final int PASSWORD_MAX_SIZE = 20;
    private static final String NOT_BLANK_MESSAGE = "필수로 입력해주세요.";
    private static final String NAME_SIZE_MESSAGE = NAME_MAX_SIZE + "자 이내로 입력해주세요.";
    private static final String EMAIL_TYPE_MESSAGE = "이메일의 형식에 맞게 입력해주세요.";
    private static final String PASSWORD_SIZE_MESSAGE = PASSWORD_MIN_SIZE + "자 이상 " +
            PASSWORD_MAX_SIZE + "자 이내로 입력해주세요.";

    @NotBlank(message = NOT_BLANK_MESSAGE)
    @Size(max = NAME_MAX_SIZE, message = NAME_SIZE_MESSAGE)
    private String name;

    @NotBlank(message = NOT_BLANK_MESSAGE)
    @Email(message = EMAIL_TYPE_MESSAGE)
    private String email;

    @NotBlank(message = NOT_BLANK_MESSAGE)
    @Size(min = PASSWORD_MIN_SIZE, max = PASSWORD_MAX_SIZE, message = PASSWORD_SIZE_MESSAGE)
    private String password;

    @NotBlank(message = NOT_BLANK_MESSAGE)
    @Size(max = NAME_MAX_SIZE, message = NAME_SIZE_MESSAGE)
    private String nickname;

    @NotBlank(message = NOT_BLANK_MESSAGE)
    private String profileImage;

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .nickname(nickname)
                .profileImage(profileImage)
                .isWithdrawn(false)
                .build();
    }

    public void encodePassword(String encoded) {
        this.password = encoded;
    }
}
