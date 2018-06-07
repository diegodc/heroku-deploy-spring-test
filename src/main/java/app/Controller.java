package app;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class Controller {

    @GetMapping
    public String cipherMessage() {
        return "Working Fine!";
    }

}