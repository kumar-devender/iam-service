package info.pragmaticdeveloper.iam.dto;

import lombok.Data;

@Data
public class UserRegisterationDTO {
    private String fistName;
    private String lastName;
    private String email;
    private String password;
}
