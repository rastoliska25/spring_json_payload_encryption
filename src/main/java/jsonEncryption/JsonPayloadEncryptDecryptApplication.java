package jsonEncryption;

import jsonEncryption.reflexion.Reflexion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class JsonPayloadEncryptDecryptApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonPayloadEncryptDecryptApplication.class, args);

        Reflexion.reflect();
    }

}
