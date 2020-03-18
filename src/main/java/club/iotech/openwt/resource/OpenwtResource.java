package club.iotech.openwt.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/boat")
class OpenwtResource {

    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }
}
