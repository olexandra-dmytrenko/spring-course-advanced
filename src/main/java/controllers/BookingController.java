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
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(path = "/ticket", method = RequestMethod.POST)
    public String bookTicketSubmit(@ModelAttribute("ticket") Ticket ticket, ModelMap modelAndView) {
        String eventName = ticket.getEvent().getName();
        Event event = eventName != null ? eventService.getByName(eventName).get(0) : null;

        String email = ticket.getUser().getEmail();
        User user = null;
        if (ticket.getUser() != null && ticket.getUser().getEmail() != null) {
            user = userService.getUserByEmail(email);
            if (user == null) {
                user = new User(email, "Undefined", LocalDate.now());
            }
        }
        Ticket ticketBooked = bookingService.bookTicket(user,
                new Ticket(event, LocalDateTime.now(), Arrays.asList(Integer.parseInt(ticket.getSeats())), user, 20));
        modelAndView.addAttribute("ticket", ticketBooked);
        return "ticket";
    }

    //    http://localhost:8080/ticket
    @RequestMapping(path = "/bookTicket", method = RequestMethod.GET)
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
