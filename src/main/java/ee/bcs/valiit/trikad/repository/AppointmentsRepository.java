package ee.bcs.valiit.trikad.repository;

import ee.bcs.valiit.trikad.bean.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {

    List<Appointments> findByUserId(Long id);

    //void delete(Optional<Appointments> appointment);
}
