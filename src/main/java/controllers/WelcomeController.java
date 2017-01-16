package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by olexandra on 07.01.17.
 * Start the app by http://localhost:8080
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcomeMessage(ModelMap modelMap) {
        modelMap.addAttribute("message", "Welcome to the Cinema Spring MVC");
        modelMap.addAttribute("bookTicketName", "Book Your ticket if there are events in the DB and users");
        modelMap.addAttribute("bookTicketUrl", "/bookTicket");
        return "welcome";
    }

    @RequestMapping(path = {"/welcome"}, method = RequestMethod.GET)
    public String welcomeMessageAdmin(ModelMap modelMap) {
        return "welcome";
    }
}
