package info.pragmaticdeveloper.iam.domain.user;

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

@Entity
@Data
@Table(name = "user_role")
public class UserRole {
    private UUID id;
    private UUID userId;
    private UUID roleId;

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
