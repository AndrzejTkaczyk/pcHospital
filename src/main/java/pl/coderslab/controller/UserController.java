//package pl.coderslab.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import pl.coderslab.dao.UserDao;
//import pl.coderslab.domain.User;
//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//    private final UserDao dao;
//
//    public UserController(UserDao dao) {
//        this.dao = dao;
//    }
//
//    @GetMapping
//    @ResponseBody
//    public String saveUser() {
//        User user = new User();
//        dao.saveUser(user);
//        return "OK";
//    }
//}
