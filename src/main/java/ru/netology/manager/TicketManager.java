package ru.netology.manager;

import ru.netology.data.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManager {
    protected TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] searchTicket(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from) || matches(ticket, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String search) {
        if (ticket.getArrivalAirport().contains(search) || ticket.getDepartureAirport().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
