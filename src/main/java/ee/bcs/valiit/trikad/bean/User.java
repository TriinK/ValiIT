package ee.bcs.valiit.trikad.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class User extends BaseEntity {

    public User(String firstname, String surname, String password, String email, boolean enabled) {
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
    }

    public User() {
    }

    @Column(name="firstname")
    private String firstname;

    @Column(name="surname")
    private String surname;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "user_id")
    private List<UserRole> roles;

}
