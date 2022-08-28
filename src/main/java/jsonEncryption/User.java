package jsonEncryption;


import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class User {

    private String name;
    private String role;

    public User(String name) {
        this.name = name;
    }
}
