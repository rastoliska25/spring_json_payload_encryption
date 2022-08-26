package jsonEncryption;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String role;

    public User(String name) {
        this.name = name;
    }
}
