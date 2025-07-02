package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateDto {
    private String username;
    private String email;

    public UserUpdateDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
