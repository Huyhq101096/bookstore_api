package book.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address_status")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressStatus {

    @Id
    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "address_status")
    private String addressStatus;
}
