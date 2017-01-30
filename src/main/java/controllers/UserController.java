package controllers;

import beans.models.Roles;
import beans.models.User;
import beans.services.UserService;
import lombok.extern.java.Log;
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
@Log
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(ModelMap modelMap) {
        List<User> users = userService.getAll();
        modelMap.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/loadUsers", method = RequestMethod.POST)
    public String loadUsersToDB() {
        try {
            String name = "Alexandra";
            LocalDateTime dateOfEvent = LocalDateTime.of(LocalDate.of(2016, 2, 5), LocalTime.of(15, 45, 0));
            User userManager = new User("o@g.com", name, LocalDate.now(), "1");
            userManager.setRoles(Roles.ROLE_BOOKING_MANAGER);
            userService.register(userManager);
            userService.register(new User("o@e.com", name, LocalDate.of(1992, 4, 29), "1"));
            User vasia = new User("a@a", "Vasia", LocalDate.of(1999, 1, 20), "1");
            vasia.setRoles(Roles.ROLE_BOOKING_MANAGER);
            userService.register(vasia);

        } catch (IllegalStateException ex) {
            log.warning("Events data from controller was already put to the DB " + ex);
        }
        return "redirect:users";
    }
}
