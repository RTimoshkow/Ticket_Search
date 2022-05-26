package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Ticket;
import ru.netology.repository.TicketRepository;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager ticket = new TicketManager(repository);

    private Ticket ticket1 = new Ticket(1, 500, "Moskow", "Taganrog", 120);
    private Ticket ticket2 = new Ticket(21, 100, "Moskow", "Taganrog", 150);
    private Ticket ticket3 = new Ticket(4, 1000, "Moskow", "Magadan", 200);
    private Ticket ticket4 = new Ticket(45, 800, "Amsterdam", "GongKong", 500);


    @BeforeEach
    void setup() {
        ticket.add(ticket1);
        ticket.add(ticket2);
        ticket.add(ticket3);
        ticket.add(ticket4);
    }

    @Test
    public void shouldSearchTicket() {
        Ticket[] actual = ticket.searchTicket("Moskow", "Taganrog");

        Arrays.sort(actual);

        Ticket[] expented = new Ticket[]{ticket2, ticket1};

        assertArrayEquals(actual, expented);
    }
}