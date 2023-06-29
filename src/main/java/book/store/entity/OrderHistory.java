package book.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistory {

    @Id
    @Column(name = "history_id")
    private Integer historyId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserOrder userOrder;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus orderStatus;

    @Column(name = "status_date")
    private LocalDateTime statusDate;
}





