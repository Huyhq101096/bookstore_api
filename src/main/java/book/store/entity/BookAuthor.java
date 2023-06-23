package book.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book_author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthor {

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
