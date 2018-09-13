package ee.bcs.valiit.trikad.repository;

import ee.bcs.valiit.trikad.bean.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {

    List<Appointments> findByUserId(Long id);
}
