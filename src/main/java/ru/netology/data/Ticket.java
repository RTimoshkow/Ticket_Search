package ru.netology.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int cost;
    protected String departureAirport;
    protected String arrivalAirport;
    protected int travelTime;


    @Override
    public int compareTo(Ticket o) {
        return cost - o.cost;
    }
}
