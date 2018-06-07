package app;

import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@RestController
@RequestMapping("test")
public class Controller {

    @GetMapping
    public String get() {
        return "Working Fine!";
    }

    @GetMapping(value = "/properties")
    public Properties getProperties() {

        return System.getProperties();
    }

}