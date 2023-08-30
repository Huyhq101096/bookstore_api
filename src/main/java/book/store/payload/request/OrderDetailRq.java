package book.store.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailRq {

    private int id;
    private String name;
    private double price;
    private String image;
    private int quantity;
}
