package nc.it.chayutpong_phongsit.project_springboot.repository;

import org.springframework.data.repository.CrudRepository;

import nc.it.chayutpong_phongsit.project_springboot.model.Book;
import nc.it.chayutpong_phongsit.project_springboot.model.Employee;
import nc.it.chayutpong_phongsit.project_springboot.model.Order;
import java.util.List;


public interface OrderRepository extends CrudRepository <Order, Integer> {
    List<Order> findByTotalPriceLessThanEqual(double totalPrice);
    List<Order> findByTotalPriceGreaterThanEqual(double totalPrice);
    List<Order> findByBook(Book book);
    List<Order> findByEmployee(Employee employee);

}