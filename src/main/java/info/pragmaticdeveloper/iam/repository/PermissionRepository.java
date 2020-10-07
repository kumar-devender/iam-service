package info.pragmaticdeveloper.iam.repository;

import info.pragmaticdeveloper.iam.domain.user.Permission;
import info.pragmaticdeveloper.iam.domain.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, UUID> {
    Role findByName(String name);
}
