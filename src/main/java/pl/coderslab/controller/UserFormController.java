package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.UserDao;
import pl.coderslab.domain.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserFormController {
    private final UserDao userDao;

    public UserFormController(UserDao userDao) {
        this.userDao = userDao;
    }
    @GetMapping("/registration")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid User user, BindingResult result) {
        userDao.saveUser(user);
        return "redirect:/";
    }
}
