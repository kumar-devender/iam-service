package info.pragmaticdeveloper.iam.repository;

import info.pragmaticdeveloper.iam.domain.user.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, UUID> {
    Credential findByUserId(UUID userId);
}
