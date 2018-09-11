package ee.bcs.valiit.trikad.сontroller;

import ee.bcs.valiit.trikad.bean.Appointments;
import ee.bcs.valiit.trikad.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointments")
    List<Appointments> apps() {
        return appointmentService.list();
    }

    @PostMapping("/add/{userId}")
    private void add(@RequestParam Long userId, @RequestParam String event_name, @RequestParam Date time, @RequestParam String description) {
        Appointments app = new Appointments();
        app.setUserId(userId);
        app.setEventname(event_name);
        app.setTime(time);
        app.setDescription(description);
        appointmentService.add(app);
    }

    //@PostMapping(value = "/delete/{id}", produces="application/json")
    //private void delete(@PathVariable Long id) {
    //    Optional<Appointments> app = appointmentService.findById(id);
    //    appointmentService.delete(app);
    //}
}
