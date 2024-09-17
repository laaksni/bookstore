package hh.s24.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.s24.bookstore.domain.Book;
import hh.s24.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Modern Time", "John Wayne", 1999, "22398-12");
			Book b2 = new Book("Why me?", "Kylia Bush", 2011, "3829-34");
			Book b3 = new Book("Not today", "Jakob Peralta", 2020, "69699-76");

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
