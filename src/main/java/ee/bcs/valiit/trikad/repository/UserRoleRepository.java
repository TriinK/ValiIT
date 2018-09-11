package ee.bcs.valiit.trikad.repository;

import ee.bcs.valiit.trikad.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
