package controllers;

import beans.daos.BookingDAO;
import beans.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by olexandra on 07.01.17.
 */
@Controller
public class BookingController {

    @Autowired
//    @Qualifier("inMemoryBookingDAO")
    BookingDAO bookingDAO;

//    @Autowired
//    @Qualifier("bookingDAO")
//    AbstractDAO abstractDAO;

    @RequestMapping(path = "/getAllTickets", method = RequestMethod.GET)
    public String getAllTickets(ModelMap modelMap) {
        List<Ticket> allTickets = bookingDAO.getAllTickets();
        modelMap.addAttribute("allTickets", allTickets);
        return "tickets";
    }
}
