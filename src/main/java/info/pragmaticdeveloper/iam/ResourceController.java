package info.pragmaticdeveloper.iam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/api/")
public class ResourceController {

    @RequestMapping("greeting/hello")
    public String hello() {
        return "hello";
    }
}
