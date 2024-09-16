package hh.s24.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping("/bookstore")
    public String bookList(Model model) {
        model.addAttribute("message", "Welcome to the Bookstore!");
        return "bookstore";
    }
    

}
