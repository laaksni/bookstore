package hh.s24.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.s24.bookstore.domain.Book;
import hh.s24.bookstore.domain.BookRepository;
import hh.s24.bookstore.domain.Category;
import hh.s24.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository cRepository) {
		return (args) -> {
			log.info("Save samples");

			Category c1 = new Category("Sci-fi");
            Category c2 = new Category("Comic");
            Category c3 = new Category("Fantasy");

			cRepository.save(c1);
            cRepository.save(c2);
            cRepository.save(c3);

			log.info("Categories saved");

            log.info("Fetch all the categories");
            for (Category category : cRepository.findAll()) {
                log.info("Category [id={}, name={}]", category.getCategoryId(), category.getName());
			}

			Book b1 = new Book("Modern Time", "John Wayne", 1999, "22398-12", c3);
			Book b2 = new Book("Why me?", "Kylia Bush", 2011, "3829-34", c2);
			Book b3 = new Book("Not today", "Jakob Peralta", 2020, "69699-76", c1);

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);

			log.info("Books saved");

            log.info("Fetch all the books");
            for (Book book : repository.findAll()) {
                log.info("Book [id={}, title={}, author={}, year={}, isbn={}]", 
                        book.getId(), book.getTitle(), book.getAuthor(), 
                        book.getPublicationYear(), book.getIsbn());
			}
		};
	}

}
