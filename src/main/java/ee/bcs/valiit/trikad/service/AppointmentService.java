package ee.bcs.valiit.trikad.service;

import ee.bcs.valiit.trikad.bean.Appointments;
import ee.bcs.valiit.trikad.repository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    public List list() {
        return appointmentsRepository.findAll();
    }

    public List<Appointments> findByUserId(Long id) {
        return appointmentsRepository.findByUserId(id);
    }
    public Appointments getOne(Long id) {
        return appointmentsRepository.getOne(id);
    }

    //@Transactional
    //public void delete(Optional<Appointments> appointment) {
    //    appointmentsRepository.delete(appointment);
    //}

    @Transactional
    public void add(Appointments appointment) {
        appointmentsRepository.save(appointment);
    }
}
