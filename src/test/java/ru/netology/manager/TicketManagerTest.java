package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Ticket;
import ru.netology.data.TicketByFastAscComparator;
import ru.netology.repository.TicketRepository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager ticket = new TicketManager(repository);

    private Ticket ticket1 = new Ticket(1, 500, "Moskow", "Taganrog", 1200);
    private Ticket ticket2 = new Ticket(21, 100, "Moskow", "Taganrog", 150);
    private Ticket ticket3 = new Ticket(4, 1000, "Piter", "Magadan", 200);
    private Ticket ticket4 = new Ticket(45, 800, "Amsterdam", "GongKong", 500);


    @BeforeEach
    void setup() {
        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
    }

    @Test
    public void shouldSearchTicketComparator() {
        Comparator<Ticket> comparator = new TicketByFastAscComparator();
        Ticket[] actual = new Ticket[]{ticket2, ticket1};
        Ticket[] expected = ticket.searchTicket("Moskow", "Taganrog", comparator);

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldNoTicket() {
        Comparator<Ticket> comparator = new TicketByFastAscComparator();
        Ticket[] actual = new Ticket[0];

        assertArrayEquals(actual, ticket.searchTicket("Moskow", "London", comparator));
    }

    @Test
    public void shouldOneTicket() {
        Comparator<Ticket> comparator = new TicketByFastAscComparator();
        Ticket[] actual = new Ticket[]{ticket3};

        assertArrayEquals(actual, ticket.searchTicket("Piter", "Magadan", comparator));
    }
}