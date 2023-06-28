package book.store.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_line")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id")
    private Integer lineId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private UserOrder custOrder;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "price")
    private BigDecimal price;
}
