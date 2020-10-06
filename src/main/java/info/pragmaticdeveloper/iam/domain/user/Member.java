package info.pragmaticdeveloper.iam.domain.user;

import info.pragmaticdeveloper.iam.dto.UserType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "member", schema = "iam_store")
public class Member extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private UserType userType;
}
