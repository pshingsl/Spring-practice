package practice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO2 {
    private Long id;
    private String username;
    private String email;
    private int no;
}
