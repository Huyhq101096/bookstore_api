package book.store.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "author_name")
    private String authorName;

    @OneToMany(mappedBy = "author")
    private List<BookAuthor> books;
}
