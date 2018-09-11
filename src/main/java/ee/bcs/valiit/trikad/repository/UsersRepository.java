package ee.bcs.valiit.trikad.repository;

import ee.bcs.valiit.trikad.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByFirstname(String firstname);

}
