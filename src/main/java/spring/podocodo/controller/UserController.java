package spring.podocodo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.podocodo.domain.constants.ResponseCode;
import spring.podocodo.domain.dto.user.UserRequestDto;
import spring.podocodo.domain.dto.user.UserResponseDto;
import spring.podocodo.domain.response.BaseResponse;
import spring.podocodo.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value =  "api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<BaseResponse> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto responseBody = userService.saveUser(userRequestDto);
        BaseResponse response = BaseResponse.from(ResponseCode.USER_SAVE, responseBody);
        return ResponseEntity.ok(response);
    }

}
