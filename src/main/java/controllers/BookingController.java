package controllers;

import beans.models.Event;
import beans.models.Ticket;
import beans.models.User;
import beans.services.BookingService;
import beans.services.EventService;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by olexandra on 07.01.17.
 */
@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;

    @RequestMapping(path = "/bookTicket", method = RequestMethod.POST)
    public String bookTicketSubmit(@PathVariable("email") String email, @PathVariable("event") String eventName) {
        Event event = eventService.getByName(eventName).get(0);
        User user = userService.getUserByEmail(email);
        Ticket ticket = bookingService.bookTicket(user, new Ticket(event, LocalDateTime.now(), Arrays.asList(0), user, 20));
        return null;
    }

//    http://localhost:8080/ticket
    @RequestMapping(path = "/ticket", method = RequestMethod.GET)
    public ModelAndView bookTicket() {
        return new ModelAndView("bookTicket", "command", new Ticket());
    }

    //http://localhost:8080/getAllTickets
    @RequestMapping(path = "/getAllTickets", method = RequestMethod.GET)
    public String getAllTickets(ModelMap modelMap) {
        //Data from request
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.of(2016, 2, 5), LocalTime.of(21, 18, 0));
        String auditorium = "Yellow hall";
        String event = "The revenant";
        // new Event(eventName, Rate.HIGH, 150,                LocalDateTime.of(LocalDate.of(2016, 2, 5), LocalTime.of(21, 18, 0)), yellowHall);
        List<Ticket> allTickets = bookingService.getTicketsForEvent(event, auditorium, dateTime);
        modelMap.addAttribute("allTickets", allTickets);
        return "tickets";
    }
}
