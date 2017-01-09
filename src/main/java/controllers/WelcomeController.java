package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by olexandra on 07.01.17.
 */
@Controller
public class WelcomeController {

    @RequestMapping(path = "/welcome", method = RequestMethod.GET)
    public String welcomeMessage(ModelMap modelMap){
        modelMap.addAttribute("message", "Welcome to the Cinema Spring MVC");
        return "welcome";
    }
}
