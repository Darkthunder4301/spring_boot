package nc.it.chayutpong_phongsit.project_springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nc.it.chayutpong_phongsit.project_springboot.model.User;
import nc.it.chayutpong_phongsit.project_springboot.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user = repository.findByUsername(username);
        UserBuilder builder = null;
            if (user.isPresent()) {
                User currentUser = user.get();
                builder = org.springframework.security.core.userdetails.
                User.withUsername(username);
                builder.password(currentUser.getPassword());
                builder.roles(currentUser.getTel());
            } else {
                throw new UsernameNotFoundException("User not found.");
            }
        return builder.build();
    }

}

