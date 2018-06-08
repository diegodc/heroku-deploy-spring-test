package app;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
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

    @GetMapping(value = "/log")
    public List<String> log() throws IOException {
        Path path = Paths.get("log.txt");
        List<String> lines = List.of(LocalDate.now().toString());

        Files.write(path, lines, Charset.forName("UTF-8"));

        return Files.readAllLines(path);
    }

}