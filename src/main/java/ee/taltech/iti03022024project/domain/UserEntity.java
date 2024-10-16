package ee.taltech.iti03022024project.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String location;

    @ManyToOne
    @JoinColumn(name = "unfinished_order", referencedColumnName = "order_id")
    private OrderEntity unfinishedOrder;

    @CreationTimestamp
    private Instant createdAt;


}
