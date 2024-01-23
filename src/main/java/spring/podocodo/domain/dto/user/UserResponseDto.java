package spring.podocodo.domain.dto.user;

import lombok.Builder;
import lombok.Getter;
import spring.podocodo.domain.entity.User;

@Getter
@Builder
public class UserResponseDto {
    private String nickname;
    private String email;
    private String profileImage;

    public static UserResponseDto from(User savedUser) {
        return UserResponseDto.builder()
                .nickname(savedUser.getNickname())
                .email(savedUser.getEmail())
                .profileImage(savedUser.getProfileImage())
                .build();
    }
}
