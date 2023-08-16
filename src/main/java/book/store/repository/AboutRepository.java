package book.store.repository;

import book.store.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AboutRepository extends JpaRepository<About,Integer> {
}
