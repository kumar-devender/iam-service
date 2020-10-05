package info.pragmaticdeveloper.iam.repository;

import info.pragmaticdeveloper.iam.domain.user.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Member, UUID> {
}
