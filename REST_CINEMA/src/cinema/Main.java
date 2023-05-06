package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
@RestController
class CinemaController {
    private final Cinema cinema = new Cinema(9, 9);

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchase(@RequestBody Seat s) {

        if (s.getRow() > cinema.getTotal_rows() || s.getRow() < 0 || s.getColumn() > cinema.getTotal_columns() || s.getColumn() < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }


        Seat s2 = cinema.getAvailable_seats().get((s.getRow() - 1) * cinema.getTotal_rows() + (s.getColumn() - 1));

        if (s2.isTaken()) throw new SeatTakenException();

        s2.setTaken(true);
        Ticket t1 = new Ticket(s2);
        cinema.purchaseTicket(t1);
        return new ResponseEntity<Ticket>(t1, HttpStatus.OK);


    }

    @PostMapping("/return")
    public ResponseEntity<String> ret(@RequestBody Token token) {


        for (Ticket t1 : cinema.getTickets()) {
            if (t1.getToken().getUuid().equals(token.getUuid())) {

                ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
                map.put("returned_ticket", t1.getSeat());
                cinema.refundTicket(t1);
                return new ResponseEntity(map, HttpStatus.OK);

            }
        }

            throw new TicketNotFoundException();
    }
    @PostMapping("/stats")
    public ResponseEntity<String> stats(@RequestParam (value="password", required = false)String pass){
        if(pass != null && pass.equals("super_secret")){
            return new ResponseEntity(Map.of("current_income",cinema.getCurrent_income() ,
                    "number_of_available_seats",cinema.getNumber_of_available_seats(),
                    "number_of_purchased_tickets", cinema.getNumber_of_purchased_tickets()),HttpStatus.OK);

        }

        throw new PasswordNotFoundException();


    }

}









