package info.pragmaticdeveloper.iam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDTO {
    @NotBlank
    private String fistName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
