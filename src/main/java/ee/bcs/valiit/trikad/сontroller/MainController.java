package ee.bcs.valiit.trikad.сontroller;

import ee.bcs.valiit.trikad.bean.AuthenticatedUser;
import ee.bcs.valiit.trikad.bean.User;
import ee.bcs.valiit.trikad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private UserService userservice;

    @RequestMapping(value = "/")
    public String index() {
        return "AppPage.html";
    }

    @RequestMapping(value="/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            return "error.html";
        }
        if (logout != null) {
            return "logout.html";
        }
        return "index.html";
    }
}
