package info.pragmaticdeveloper.iam.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Data
@Entity
@Table(name = "role", schema = "iam_store")
public class Role extends BaseEntity {
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")}
    )
    private Collection<Permission> permissions = new HashSet<>();
}
