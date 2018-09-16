package ee.bcs.valiit.trikad.сontroller;

import com.google.common.hash.Hashing;
import ee.bcs.valiit.trikad.PasswordEncoder;
import ee.bcs.valiit.trikad.bean.Appointments;
import ee.bcs.valiit.trikad.bean.User;
import ee.bcs.valiit.trikad.bean.UserRole;
import ee.bcs.valiit.trikad.service.AppointmentService;
import ee.bcs.valiit.trikad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userservice;

    @GetMapping("/appointmentslist")
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

    @GetMapping(value = "/get/{id}", produces = "application/json")
    public Appointments get(@PathVariable Long id) {
        return appointmentService.getOne(id);
    }

    @PostMapping(value = "/delete/{id}", produces="application/json")
    private void delete(@PathVariable Long id) {
        Appointments app = appointmentService.getOne(id);
        appointmentService.delete(app);
    }
    @RequestMapping(value = "/newuser")
    public void newUser(@RequestBody User user) {
        PasswordEncoder pass = new PasswordEncoder(user.getPassword());
        User newuser = new User();
        newuser.setFirstname(user.getFirstname());
        newuser.setSurname(user.getSurname());
        newuser.setEmail(user.getEmail());
        newuser.setPassword(pass.print());
        newuser.setEnabled(true);
        userservice.save(newuser);
    }
}