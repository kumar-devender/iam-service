package info.pragmaticdeveloper.iam.domain.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "role_permission", schema = "iam_store")
public class RolePermission extends BaseEntity {
    @Column(name = "role_id")
    private UUID roleId;
    @Column(name = "permission_id")
    private UUID permissionId;
}
