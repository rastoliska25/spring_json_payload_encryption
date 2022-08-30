package jsonEncryption;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Data
@Document
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
