package book.store.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "shipping_method")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "cost")
    private BigDecimal cost;

    @OneToMany(mappedBy = "shippingMethod")
    private List<UserOrder> userOrders;
}