package ee.bcs.valiit.trikad.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm", timezone = "Europe/Tallinn")
    private Date time;


    @Column(name="description")
    private String description;

}
