package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Ticket {

    @JsonUnwrapped
    private Token token;
    @JsonProperty("ticket")
    private Seat seat;

    public Ticket(Seat seat) {
        this.token = new Token();
        this.seat = seat;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}