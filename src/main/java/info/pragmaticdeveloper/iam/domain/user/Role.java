package info.pragmaticdeveloper.iam.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "role", schema = "iam_store")
public class Role extends BaseEntity {
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "role_permission", schema = "iam_store",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")}
    )
    private Set<Permission> permissions = new HashSet<>();
}
