package ee.bcs.valiit.trikad.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

    @Data
    @MappedSuperclass
    public abstract class BaseEntity implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
    }
