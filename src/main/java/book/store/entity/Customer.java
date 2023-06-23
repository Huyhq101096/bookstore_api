package book.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "customer")
    private CustomerAddress customerAddress;
}
