package controllers;

import beans.models.User;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by olexandra on 22.01.17.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(ModelMap modelMap){
        List<User> users = userService.getAll();
        modelMap.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/loadUsers", method = RequestMethod.POST)
    public String loadUsersToDB() {
        String email1 = "o@g.com";
        String name = "Dmytro Babichev";
        LocalDateTime dateOfEvent = LocalDateTime.of(LocalDate.of(2016, 2, 5), LocalTime.of(15, 45, 0));

        userService.register(new User(email1, name, LocalDate.now()));
        String email2 = "o@e.com";
        userService.register(new User(email2, name, LocalDate.of(1992, 4, 29)));
        return "redirect:users";
    }
}
