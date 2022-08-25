package jsonEncryption;

import jsonEncryption.InstrumentationalAgent.InstrumentationAgent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class JsonPayloadEncryptDecryptApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonPayloadEncryptDecryptApplication.class, args);

        //User user = new User("ferko", "testovanie");

        //Logger.logger.info(", size: " + InstrumentationAgent.getObjectSize(user) + " bytes");

        Logger.logger.info("appinfo,{},{}", 500, 1682458);

    }

}
