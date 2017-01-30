package controllers;

import beans.models.Event;
import beans.models.Rate;
import beans.services.AuditoriumService;
import beans.services.EventService;
import beans.services.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by olexandra on 07.01.17.
 */
@Log
@Controller
public class EventsController {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @Autowired
    AuditoriumService auditoriumService;

    @RequestMapping(path = "/events", method = RequestMethod.GET)
    public String showAllEvents(ModelMap modelMap) {
        List<Event> events = eventService.getAll();
        modelMap.addAttribute("events", events);
        return "events";
    }

    @RequestMapping(path = "/events", method = RequestMethod.POST)
    public String loadDummyvEnts(ModelMap modelMap) {
        try {
            eventService.create(new Event("Movie", Rate.LOW, 12, LocalDateTime.of(2017, 2, 10, 12, 45), auditoriumService.getByName("Blue hall")));
            eventService.create(new Event("Movie", Rate.HIGH, 12, LocalDateTime.of(2017, 2, 11, 12, 45), auditoriumService.getByName("Blue hall")));
            eventService.create(new Event("Valentine's Day", Rate.HIGH, 45, LocalDateTime.of(2017, 2, 10, 22, 45), auditoriumService.getByName("Red hall")));
            eventService.create(new Event("Valentine's Day", Rate.HIGH, 48, LocalDateTime.of(2017, 2, 10, 20, 0), auditoriumService.getByName("Yellow hall")));
            eventService.create(new Event("Concert", Rate.MID, 20, LocalDateTime.of(2017, 2, 12, 12, 45), auditoriumService.getByName("Yellow hall")));
            eventService.create(new Event("Concert", Rate.HIGH, 22, LocalDateTime.of(2017, 2, 12, 20, 0), auditoriumService.getByName("Red hall")));
        } catch (IllegalStateException ex) {
            log.warning("Events data from controller was already put to the DB " + ex);
        }
        return "redirect:events";
    }
}
