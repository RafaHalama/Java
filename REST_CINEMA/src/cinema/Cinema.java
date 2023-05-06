package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Cinema{
    private int total_rows;
    private int total_columns;
    private ArrayList<Seat> available_seats;
    @JsonIgnore
    private ArrayList<Ticket> tickets;
    @JsonIgnore
    private int current_income;
    @JsonIgnore
    private int number_of_available_seats;
    @JsonIgnore
    private int number_of_purchased_tickets;

    public int getCurrent_income() {
        return current_income;
    }

    public void setCurrent_income(int current_income) {
        this.current_income = current_income;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void setNumber_of_available_seats(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }

    public void setNumber_of_purchased_tickets(int number_of_purchased_tickets) {
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }

    public Cinema(){}
    public Cinema(int total_rows, int total_columns){
        this.total_columns = total_columns;
        this.total_rows = total_rows;
        available_seats = new ArrayList<Seat>();
        tickets = new ArrayList<Ticket>();
        for(int i=1;i<=this.total_rows;i++){
            for(int j=1;j<=this.total_columns;j++){
                if(i<=4) this.available_seats.add(new Seat(i,j,10));
                else this.available_seats.add(new Seat(i,j,8));

            }
        }
        number_of_available_seats = total_columns * total_rows;

    }
    public void purchaseTicket(Ticket ticket){
        this.tickets.add(ticket);
        this.number_of_available_seats -=1;
        this.number_of_purchased_tickets +=1;
        this.current_income += ticket.getSeat().getPrice();
    }
    public void refundTicket(Ticket ticket){
        this.tickets.remove(ticket);
        this.number_of_available_seats +=1;
        this.number_of_purchased_tickets -=1;
        this.current_income -= ticket.getSeat().getPrice();
    }
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public ArrayList<Seat> getAvailable_seats() {

        return available_seats;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public void setAvailable_seats(ArrayList<Seat> available_seats) {
        this.available_seats = available_seats;
    }
}