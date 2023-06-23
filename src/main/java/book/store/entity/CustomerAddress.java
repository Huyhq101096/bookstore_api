package book.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

    @Id
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private AddressStatus addressStatus;
}
