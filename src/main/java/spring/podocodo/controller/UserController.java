package spring.podocodo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.podocodo.domain.constants.ResponseCode;
import spring.podocodo.domain.dto.user.SignUpRequestDto;
import spring.podocodo.domain.dto.user.SignUpResponseDto;
import spring.podocodo.domain.response.BaseResponse;
import spring.podocodo.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value =  "api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<BaseResponse> createUser(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        SignUpResponseDto responseBody = userService.saveUser(signUpRequestDto);
        BaseResponse response = BaseResponse.from(ResponseCode.USER_SAVE, responseBody);
        return ResponseEntity.ok(response);
    }

}
