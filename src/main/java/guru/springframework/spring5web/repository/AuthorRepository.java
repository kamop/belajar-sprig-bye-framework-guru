package guru.springframework.spring5web.repository;

import guru.springframework.spring5web.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
