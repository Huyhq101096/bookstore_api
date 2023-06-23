package book.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "country_name")
    private String countryName;
}
