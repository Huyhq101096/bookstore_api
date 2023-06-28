package book.store.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "shipping_method_id")
    private ShippingMethod shippingMethod;

    @ManyToOne
    @JoinColumn(name = "dest_address_id")
    private Address destAddress;

    @OneToMany(mappedBy = "userOrder")
    private List<OrderLine> orderLines;

    @OneToMany(mappedBy = "userOrder")
    private List<OrderHistory> orderHistories;
}
