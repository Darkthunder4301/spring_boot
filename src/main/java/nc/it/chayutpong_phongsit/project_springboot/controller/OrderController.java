package nc.it.chayutpong_phongsit.project_springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nc.it.chayutpong_phongsit.project_springboot.model.Book;
import nc.it.chayutpong_phongsit.project_springboot.model.Employee;
import nc.it.chayutpong_phongsit.project_springboot.model.Order;
import nc.it.chayutpong_phongsit.project_springboot.repository.OrderRepository;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/order")
    public Iterable<Order> getAll(){
        return orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public Optional<Order> getById(@PathVariable int id){
        return orderRepository.findById(id);
    }

    @GetMapping("/order/price/lessthan/{price}")
    public Iterable<Order> getByPriceLessThanEqual(@PathVariable Double totalPrice){
        return orderRepository.findByTotalPriceLessThanEqual(totalPrice);
    }

    @GetMapping("/order/price/greaterthan/{price}")
    public Iterable<Order> getByPriceGreaterThanEqual(@PathVariable Double totalPrice){
        return orderRepository.findByTotalPriceGreaterThanEqual(totalPrice);
    }

    @GetMapping("/order/book/{book}")
    public Iterable<Order> getByNameContaining(@PathVariable Book book){
        return orderRepository.findByBook(book);
    }

    @GetMapping("/order/emp/{emp}")
    public Iterable<Order> getByNameContaining(@PathVariable Employee emp){
        return orderRepository.findByEmployee(emp);
    }

    @PostMapping("/order")
    public ResponseEntity<Order> create(@RequestBody Order order){
        Order newOrder = orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }
}

