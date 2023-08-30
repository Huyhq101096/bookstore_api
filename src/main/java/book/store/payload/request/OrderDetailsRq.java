package book.store.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsRq {

    private int id;
    private String name;
    private String image;
    private int quantity;
    private double price;


}
