package nc.it.chayutpong_phongsit.project_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import nc.it.chayutpong_phongsit.project_springboot.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired UserService userService;
    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    //     UserDetails user = User.builder().username("user").
    //         password(passwordEncoder().encode("password"))
    //         .roles("USER").build();
    //     return new InMemoryUserDetailsManager(user);
    // }

    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
