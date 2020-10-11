package info.pragmaticdeveloper.iam.domain.client;

import info.pragmaticdeveloper.iam.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "SCOPE")
public class Scope extends BaseEntity {
    private String name;
    private String description;
}
