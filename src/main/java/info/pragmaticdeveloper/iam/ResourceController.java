package info.pragmaticdeveloper.iam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/")
public class ResourceController {

    @RequestMapping("greeting/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("greeting/hi")
    public String hi() {
        return "hello";
    }
}
