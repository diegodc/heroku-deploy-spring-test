package app;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        Path log = verifyLogFile();

        String login = getLoginStamp();

        write(log, login);

        return Files.readAllLines(log);
    }

    private Path verifyLogFile() throws IOException {
        File file = Paths.get("log.txt").toFile();

        if (!file.exists())
            file.createNewFile();

        return file.toPath();
    }

    private String getLoginStamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    private void write(Path log, String login) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(log, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write(login);
            writer.newLine();
        }
    }

}