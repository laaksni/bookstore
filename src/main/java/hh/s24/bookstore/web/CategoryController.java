package hh.s24.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.s24.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist";
    }

    @RequestMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new hh.s24.bookstore.domain.Category());
        return "addcategory";
    }

    @RequestMapping("/savecategory")
    public String saveCategory(hh.s24.bookstore.domain.Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }
}
