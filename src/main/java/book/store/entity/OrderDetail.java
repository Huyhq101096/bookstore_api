package book.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import book.store.entity.ids.OrderDetailsIds;

@Entity
@Table(name = "order_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @EmbeddedId
    OrderDetailsIds ids;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;
    

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false,updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false,updatable = false)
    private Order order;

}





