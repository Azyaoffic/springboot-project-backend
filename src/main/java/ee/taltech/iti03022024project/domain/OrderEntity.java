package ee.taltech.iti03022024project.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name="status_id", referencedColumnName = "status_id")
    private StatusEntity status;
}
