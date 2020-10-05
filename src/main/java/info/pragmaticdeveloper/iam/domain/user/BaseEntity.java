package info.pragmaticdeveloper.iam.domain.user;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseEntity {
    @Id
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @CreatedBy
    @Column(updatable = false)
    private UUID createdBy;

    @CreatedDate
    @Column(updatable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedOn;
}
