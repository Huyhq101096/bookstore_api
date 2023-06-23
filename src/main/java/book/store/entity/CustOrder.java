package book.store.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cust_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipping_method_id")
    private ShippingMethod shippingMethod;

    @ManyToOne
    @JoinColumn(name = "dest_address_id")
    private Address destAddress;

    @OneToMany(mappedBy = "custOrder")
    private List<OrderLine> orderLines;

    @OneToMany(mappedBy = "custOrder")
    private List<OrderHistory> orderHistories;
}
