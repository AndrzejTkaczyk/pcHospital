package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.UserDao;
import pl.coderslab.domain.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class MainController {
    private final UserDao userDao;

    public MainController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/")
    public String displayHome() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginSave(Model model, @RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userDao.findUserByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("error", "Błędny login lub hasło!");
            return "login";
        } else {
            session.setAttribute("user", user);
            return "user/index";
        }
    }

    @GetMapping("/errorLogin")
    public String errorLogin() {
        return "errorLogin";
    }

    @GetMapping("/registration")
    public String registrationView(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping("/registrationEdit/{id}")
    public String registrationEdit(@PathVariable long id, Model model) {
        User user = userDao.findById(id);
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSave(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        } if (user.getId() != null) {
            userDao.updateUser(user);
        } else {
            user.setCreatedOn(LocalDateTime.now());
            userDao.saveUser(user);
        }
        return "login";
    }
}
