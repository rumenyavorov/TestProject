/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tests;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
@EntityScan(value = "tests.domain")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/mvvm")
    public String mvvmExample() {
        return "mvvm";
    }

    @GetMapping("/resources")
    public String resourcesExample() {
        return "resources";
    }

}
