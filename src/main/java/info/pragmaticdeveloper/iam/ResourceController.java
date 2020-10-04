package info.pragmaticdeveloper.iam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/")
public class ResourceController {

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public String register() {
        return "register";
    }
}
