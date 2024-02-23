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

import nc.it.chayutpong_phongsit.project_springboot.model.Employee;
import nc.it.chayutpong_phongsit.project_springboot.repository.EmpRepository;

@RestController
public class EmpController {
    @Autowired
    private EmpRepository empRepository;
    @GetMapping("/emp")
    public Iterable<Employee> getAll(){
        return empRepository.findAll();
    }

    @GetMapping("/emp/{id}")
    public Optional<Employee> getById(@PathVariable int id){
        return empRepository.findById(id);
    }

    @GetMapping("/emp/name/{name}")
    public Iterable<Employee> getByNameContaining(@PathVariable String name){
        return empRepository.findByNameContaining(name);
    }

    @PostMapping("/emp")
    public ResponseEntity<Employee> create(@RequestBody Employee emp){
        Employee newEmp = empRepository.save(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmp);
    }
}
