package book.store.payload.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UOrderRq {

    private int shippingId;
    private List<OrderDetailsRq> order;
    
}
