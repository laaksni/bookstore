package hh.s24.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hh.s24.bookstore.domain.Book;
import hh.s24.bookstore.domain.BookRepository;
import hh.s24.bookstore.domain.CategoryRepository;


@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository cRepository;

    @RequestMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add", method=RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepository.findAll());
        return "addbook";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:/booklist";
    }
    
}
