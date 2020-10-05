package info.pragmaticdeveloper.iam;

import info.pragmaticdeveloper.iam.dto.UserRegistrationDTO;
import info.pragmaticdeveloper.iam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegistrationDTO register(@Validated @RequestBody UserRegistrationDTO registrationDTO) {
        return userService.createUser(registrationDTO);
    }
}
