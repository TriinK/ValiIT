package ee.bcs.valiit.trikad.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

    @Entity
    @Table(name = "role")
    @Data
    @EqualsAndHashCode(callSuper = false)
    @ToString(callSuper = true)
    public class Role extends BaseEntity {

        @Column(name = "name")
        private String name;

        @OneToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "role_id")
        private List<UserRole> users;

    }
