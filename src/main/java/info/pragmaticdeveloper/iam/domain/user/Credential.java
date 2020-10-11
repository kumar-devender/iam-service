package info.pragmaticdeveloper.iam.domain.user;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Data
@Entity
@Table(name = "credential", schema = "iam_store")
public class Credential extends BaseEntity implements Serializable {
    @Type(type = "pg-uuid")
    @Column(name = "user_id")
    private UUID userId;
    private String password;
    private Boolean enabled;

    @ManyToMany
    @JoinTable(
            name = "credential_role", schema = "iam_store",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Collection<Role> roles = new HashSet<>();
}
