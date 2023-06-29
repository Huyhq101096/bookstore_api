package book.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "order_status")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status_value")
    private String statusValue;

    @OneToMany(mappedBy = "orderStatus")
    private List<OrderHistory> orderHistories;
}
