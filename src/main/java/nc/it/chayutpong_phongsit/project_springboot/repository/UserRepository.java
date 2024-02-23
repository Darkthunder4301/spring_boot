package nc.it.chayutpong_phongsit.project_springboot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import nc.it.chayutpong_phongsit.project_springboot.model.User;
import java.util.List;


@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Integer>{
    Optional<User> findByUsername(String username);
    List<User> findByNameContaining(String name);
}