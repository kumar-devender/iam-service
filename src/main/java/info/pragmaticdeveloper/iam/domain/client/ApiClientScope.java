package info.pragmaticdeveloper.iam.domain.client;

import info.pragmaticdeveloper.iam.domain.user.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "api_client_scope")
public class ApiClientScope extends BaseEntity {
    @Type(type = "pg-uuid")
    private UUID apiClientId;
    @Type(type = "pg-uuid")
    private UUID scopeId;
}
