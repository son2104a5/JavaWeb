package demo.ss10.controller;

import demo.ss10.model.Seat;
import demo.ss10.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class BookingController {

    @GetMapping("/booking-form")
    public String showForm(Model model) {
        Ticket ticket = new Ticket();
        ticket.setSeats(Arrays.asList(
                new Seat("A1", false),
                new Seat("A2", false),
                new Seat("A3", false),
                new Seat("B1", false),
                new Seat("B2", false)
        ));
        model.addAttribute("ticket", ticket);
        return "B8/bookingForm";
    }

    @PostMapping("/book-ticket")
    public String bookTicket(@ModelAttribute Ticket ticket, Model model) {
        double pricePerSeat = 50000;
        List<Seat> selectedSeats = new ArrayList<>();

        for (Seat seat : ticket.getSeats()) {
            if (seat.isSelected()) {
                selectedSeats.add(seat);
            }
        }

        ticket.setSeats(selectedSeats);
        ticket.setTotalAmount(selectedSeats.size() * pricePerSeat);
        model.addAttribute("ticket", ticket);

        return "B8/ticketResult";
    }
}
