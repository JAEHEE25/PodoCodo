package spring.podocodo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.podocodo.domain.dto.user.SignUpRequestDto;
import spring.podocodo.domain.dto.user.SignUpResponseDto;
import spring.podocodo.domain.entity.User;
import spring.podocodo.domain.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SignUpResponseDto saveUser(SignUpRequestDto signUpRequestDto) {
        signUpRequestDto.encodePassword(passwordEncoder.encode(signUpRequestDto.getPassword()));
        User newUser = signUpRequestDto.toEntity();
        return SignUpResponseDto.from(userRepository.save(newUser));
    }
}
