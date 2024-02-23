package nc.it.chayutpong_phongsit.project_springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nc.it.chayutpong_phongsit.project_springboot.model.User;
import nc.it.chayutpong_phongsit.project_springboot.model.Book;
import nc.it.chayutpong_phongsit.project_springboot.model.Employee;
import nc.it.chayutpong_phongsit.project_springboot.repository.UserRepository;
import nc.it.chayutpong_phongsit.project_springboot.repository.BookRepository;
import nc.it.chayutpong_phongsit.project_springboot.repository.EmpRepository;

@SpringBootApplication
public class ProjectSpringbootApplication implements CommandLineRunner {

 public static void main(String[] args) {
  SpringApplication.run(ProjectSpringbootApplication.class, args);
 }

 private final BookRepository bookRepository;

 private final EmpRepository eventRepository;
 private final UserRepository userRepository;

 public ProjectSpringbootApplication(BookRepository bookRepository, EmpRepository eventRepository,
   UserRepository userRepository) {
  this.bookRepository = bookRepository;
  this.eventRepository = eventRepository;
  this.userRepository = userRepository;
 }

 @Override
 public void run(String... args) throws Exception {
  Book book1 = new Book("The Call of Cthulhu", "H. P. Lovecraft", 400);
  Book book2 = new Book("Song of Fire and Ice", "George R. R. Martin", 380);
  Book book3 = new Book("Harry Potter", "J. K. Rowling", 395);
  Book book4 = new Book("Moby Dick", "Herman Melville", 684);
  Book book5 = new Book("The Art of War", "Sun Tzu", 179);
  bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5));

  eventRepository.save(new Employee("Diluc Ragnvindr", "0811111111"));
  eventRepository.save(new Employee("Kaeya Alberich", "0822222222"));
  eventRepository.save(new Employee("Eula Lawrence", "0833333333"));
  eventRepository.save(new Employee("Jean Gunnhildr", "0844444444"));

  // Username: user, password: 12345678
  userRepository.save(new User("user", "$2a$12$9ehl4dkD0iiAMSbZVdXGbuJ./XPZCOSArtTgn8SdCYQqZIvWrrO8e", "USER", "0855555555"));
  // Username: admin, password: admin
  userRepository.save(new User("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN", "0866666666"));
 }
}
