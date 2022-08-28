package jsonEncryption;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@Data
@Setter
@EqualsAndHashCode
public class Statue {

    private String name;

    private Integer typeId;

    private Long weight;

    private Long length;

    private Long width;

    private Long height;

}
