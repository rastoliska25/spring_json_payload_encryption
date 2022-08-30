package jsonEncryption;

import jsonEncryption.reflexion.Reflexion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication()
@EnableJpaRepositories("jsonEncryption")
@EnableMongoRepositories(basePackages = "jsonEncryption")
@ComponentScan({"jsonEncryption"})
@EntityScan("jsonEncryption")
public class JsonPayloadEncryptDecryptApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonPayloadEncryptDecryptApplication.class, args);

        Reflexion.reflect();
        EqualsHashcode.equalsHashcode();

    }

    @Bean
    CommandLineRunner runner(UserRepository repository) {
        return args -> {
          User user = new User("Ferko3", "User");

            repository.findUserByName(user.getName())
                    .ifPresentOrElse(u -> {
                        System.out.println(u + "uz existuje");
                    }, ()-> {
                        System.out.println("vklada sa user " + user);
                        repository.insert(user);
                    });
        };

    };
}
