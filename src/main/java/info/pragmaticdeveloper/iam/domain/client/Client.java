package info.pragmaticdeveloper.iam.domain.client;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "api_client")
public class Client {
    private UUID id;
    private String clientId;
    private String secret;

    @CreatedBy
    @Column(updatable = false)
    private UUID createdBy;

    @CreatedDate
    @Column(updatable = false)
    @Type(type = "PersistentDateTime")
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Type(type = "PersistentDateTime")
    private LocalDateTime updatedOn;
}
