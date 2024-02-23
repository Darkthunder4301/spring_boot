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
import nc.it.chayutpong_phongsit.project_springboot.repository.BookRepository;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public Iterable<Book> getAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getById(@PathVariable int id){
        return bookRepository.findById(id);
    }

    @GetMapping("/book/price/{price}")
    public Iterable<Book> getByPriceLessThanEqual(@PathVariable String price){
        return bookRepository.findByPriceLessThanEqual(price);
    }

    @GetMapping("/book/name/{name}")
    public Iterable<Book> getByNameContaining(@PathVariable String name){
        return bookRepository.findByNameContaining(name);
    }

    @PostMapping("/book")
    public ResponseEntity<Book> create(@RequestBody Book book){
        Book newBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }
}
