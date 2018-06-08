package app;

import org.hibernate.validator.internal.metadata.location.FieldConstraintLocation;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
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

    @GetMapping(value = "/file")
    public String fileTest() {
        File file = new File("test");

        if (file.exists()) {
            file.delete();
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(file.exists());
    }

}