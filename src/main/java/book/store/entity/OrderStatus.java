package book.store.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "order_status")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {

    @Id
    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "status_value")
    private String statusValue;

    @OneToMany(mappedBy = "orderStatus")
    private List<OrderHistory> orderHistories;
}
