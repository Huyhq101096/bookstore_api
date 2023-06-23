package book.store.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn13")
    private String isbn13;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private BookLanguage bookLanguage;

    @Column(name = "num_pages")
    private Integer numPages;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private List<BookAuthor> authors;
}
