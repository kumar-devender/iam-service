package info.pragmaticdeveloper.iam.domain.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "permission", schema = "iam_store")
public class Permission extends BaseEntity {
    private String name;
    private String description;
}
