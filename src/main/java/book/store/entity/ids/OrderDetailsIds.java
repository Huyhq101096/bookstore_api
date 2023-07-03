package book.store.entity.ids;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsIds implements Serializable {
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "order_id")
    private int orderId;
}
