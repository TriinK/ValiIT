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
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userservice;

    @RequestMapping(value = "/home")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            return "/static/error.html";
        }
        if (logout != null) {
            return "/static/logout.html";
        }
        return "/static/AppPage.html";
    }

    //Sisselogimine autentimisega
    @RequestMapping(value = "/user")
    @ResponseBody
    public AuthenticatedUser user() {
        AuthenticatedUser principal = new AuthenticatedUser();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userservice.findByEmail(authentication.getName());
        if (user != null) {
            principal.setId(user.getId());
            principal.setUsername(user.getEmail());
            principal.setName(user.getFirstname());
            principal.setEmail(user.getEmail());
            principal.setRoles(AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
        }
        return principal;
    }
    @RequestMapping(value = "/newuser")
    public void newUser(@RequestBody User user) {
        User newuser = new User();
        newuser.setFirstname(user.getFirstname());
        newuser.setSurname(user.getSurname());
        newuser.setEmail(user.getEmail());
        newuser.setPassword(user.getPassword());
        userservice.save(newuser);
    }
}
