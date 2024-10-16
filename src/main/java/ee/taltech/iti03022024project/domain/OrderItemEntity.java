package ee.taltech.iti03022024project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName = "order_id")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "product_id")
    private ProductEntity product;
    private int quantity;
    private double priceAtTimeOfOrder;
}
