package ee.bcs.valiit.trikad.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

    @Entity
    @Table(name = "user_role")
    @Data
    @EqualsAndHashCode(callSuper = false)
    @ToString(callSuper = true)
    public class UserRole extends BaseEntity {

        @Column(name = "user_id", nullable = false)
        private Long userId;

        @Column(name = "role_id", nullable = false)
        private Long roleId;

        @SuppressWarnings("unused")
        public UserRole() {
        }

        public UserRole(Long userId, Long roleId) {
            this.userId = userId;
            this.roleId = roleId;
        }

    }
