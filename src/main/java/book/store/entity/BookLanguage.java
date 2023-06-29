package book.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "book_language")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Integer languageId;

    @Column(name = "language_code")
    private String languageCode;

    @Column(name = "language_name")
    private String languageName;

    @OneToMany(mappedBy = "bookLanguage")
    private List<Book> books;
}
