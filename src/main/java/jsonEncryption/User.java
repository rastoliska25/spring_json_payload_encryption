package jsonEncryption;


import lombok.Builder;

@Builder
public class User {

    private String name;
    private String role;

    public String getName() {
        return name;
    }
}
