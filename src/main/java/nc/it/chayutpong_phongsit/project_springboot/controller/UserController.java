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

import nc.it.chayutpong_phongsit.project_springboot.model.User;
import nc.it.chayutpong_phongsit.project_springboot.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/user")
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getById(@PathVariable int id){
        return userRepository.findById(id);
    }

    @GetMapping("/user/uid/{username}")
    public Optional<User> getByUsername(@PathVariable String username){
        return userRepository.findByUsername(username);
    }

    @GetMapping("/user/name/{name}")
    public Iterable<User> getByNameContaining(@PathVariable String name){
        return userRepository.findByNameContaining(name);
    }

    @PostMapping("/user")
    public ResponseEntity<User> create(@RequestBody User user){
        User newBook = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }
}
