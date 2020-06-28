package panel.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:db.properties")
public class BMIApplication {

    public static void main(String[] args) {
        SpringApplication.run(BMIApplication.class, args);
    }

}
