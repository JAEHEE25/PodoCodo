package spring.podocodo.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.podocodo.domain.entity.User;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @
    private String name;
    private String email;
    private String password;
    private String nickname;
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
}
