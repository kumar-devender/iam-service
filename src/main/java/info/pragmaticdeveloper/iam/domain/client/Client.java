package info.pragmaticdeveloper.iam.domain.client;

import info.pragmaticdeveloper.iam.domain.user.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "api_client")
public class Client extends BaseEntity {
    private String clientId;
    private String secret;
}
