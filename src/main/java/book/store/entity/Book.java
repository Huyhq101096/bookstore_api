package book.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String name;

    @Column(name = "isbn13")
    private String isbn13;

    @Column(name = "description")
    private String desc;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "rating")
    private float rating;

    @Column(name = "num_pages")
    private Integer numPages;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private BookLanguage bookLanguage;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private List<BookAuthor> authors;

    @OneToMany(mappedBy = "book")
    private Set<OrderDetail> orderDetails;

}
