package spring.podocodo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import spring.podocodo.domain.dto.user.UserRequestDto;
import spring.podocodo.domain.dto.user.UserResponseDto;
import spring.podocodo.domain.entity.User;
import spring.podocodo.domain.repository.UserRepository;
import spring.podocodo.domain.response.BaseResponse;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        User newUser = userRequestDto.toEntity();
        return UserResponseDto.from(userRepository.save(newUser));
    }
}
