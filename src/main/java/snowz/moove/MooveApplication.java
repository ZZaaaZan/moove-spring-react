package snowz.moove;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class MooveApplication {

    public static void main(String[] args) {
        SpringApplication.run(MooveApplication.class, args);
    }

}
