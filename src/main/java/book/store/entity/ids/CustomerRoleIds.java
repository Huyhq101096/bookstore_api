package book.store.entity.ids;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Embeddable
@Data
@AllArgsConstructor
public class CustomerRoleIds implements Serializable {

    @Column(name = "customer_id")
    private Integer customerId;
    
    @Column(name = "role_id")
    private Integer roleId;
    
}
