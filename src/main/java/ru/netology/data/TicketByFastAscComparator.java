package ru.netology.data;

import java.util.Comparator;

public class TicketByFastAscComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}