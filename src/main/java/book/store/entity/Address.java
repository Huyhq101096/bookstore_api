package book.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToOne(mappedBy = "address")
    private CustomerAddress customerAddress;
}