package ee.bcs.valiit.trikad.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="appointments")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Appointments extends BaseEntity {

    public Appointments() {
    }

    public Appointments(Long userId, String eventname, Date time, String description) {
        this.userId = userId;
        this.eventname = eventname;
        this.time = time;
        this.description = description;
    }

    @Column(name="user_id")
    private Long userId;

    @Column(name="event_name")
    private String eventname;

    @Column(name="time")
    private Date time;


    @Column(name="description")
    private String description;

}
