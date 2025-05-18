package demo.ss10.controller;

import demo.ss10.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/library")
public class LibraryController {

    private List<Book> books = new ArrayList<>();
    private Long idCounter = 1L;

    @GetMapping("/list")
    public String showBooks(Model model) {
        model.addAttribute("books", books);
        return "B9/bookList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "B9/bookForm";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        try {
            if (!book.getFile().isEmpty()) {
                String fileName = book.getFile().getOriginalFilename();
                String uploadPath = "E:/JavaWeb/ss10/src/main/webapp/WEB-INF/fileUpload/" + fileName;
                book.getFile().transferTo(new File(uploadPath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        book.setId(idCounter++);
        books.add(book);
        return "redirect:/library/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("book", book);
        return "B9/bookForm";
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute Book book) {
        books.removeIf(b -> b.getId().equals(book.getId()));
        books.add(book);
        return "redirect:/library/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        books.removeIf(b -> b.getId().equals(id));
        return "redirect:/library/list";
    }
}
