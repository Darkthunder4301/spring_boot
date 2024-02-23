package nc.it.chayutpong_phongsit.project_springboot.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import nc.it.chayutpong_phongsit.project_springboot.model.Book;

@RepositoryRestResource(path = "book")
public interface BookRepository extends CrudRepository<Book, Integer>{
    List<Book> findByPriceLessThanEqual(@Param("price") String price);
    // List<Book> findByPriceGreaterThanEqual(@Param("price") String price);
    List<Book> findByNameContaining(@Param("name") String name);
}