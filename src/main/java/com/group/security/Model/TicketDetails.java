package com.group.security.Model;
import jakarta.persistence.*;

@Entity
public class TicketDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "event_id")
    private String eventId;

    private String ticketType;
    private double ticketPrice;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "eventId", insertable = false, updatable = false)
    private Eventcards eventcards;

    // Default constructor
    public TicketDetails() {}

    // Constructor for the custom query
    public TicketDetails(int id, String eventId, String ticketType, double ticketPrice) {
        this.id = id;
        this.eventId = eventId;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Eventcards getEventcards() {
        return eventcards;
    }

    public void setEventcards(Eventcards eventcards) {
        this.eventcards = eventcards;
    }

}
