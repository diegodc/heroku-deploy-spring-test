package app;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("test")
public class Controller {

    @GetMapping
    public String get() {
        return "Application Deployed!!!";
    }

    @GetMapping(value = "/properties")
    public Properties getProperties() {
        return System.getProperties();
    }

    @GetMapping(value = "/environment")
    public Map<String, String> getEnvironment() {
        return System.getenv();
    }

}