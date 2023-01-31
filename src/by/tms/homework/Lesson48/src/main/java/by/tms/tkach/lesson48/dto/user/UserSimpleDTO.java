package by.tms.tkach.lesson48.dto.user;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSimpleDTO implements UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
}
