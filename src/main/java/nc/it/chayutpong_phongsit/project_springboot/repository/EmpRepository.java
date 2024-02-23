package nc.it.chayutpong_phongsit.project_springboot.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import nc.it.chayutpong_phongsit.project_springboot.model.Employee;
import java.util.List;


@RepositoryRestResource(path = "employee")
public interface EmpRepository extends CrudRepository<Employee, Integer>{
    List<Employee> findByNameContaining(String name);
}