package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class TicketNotFoundException extends RuntimeException {

    public TicketNotFoundException() {
        super();
    }
}
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class SeatTakenException extends RuntimeException {

    public SeatTakenException() {
        super();
    }
}
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
class PasswordNotFoundException extends RuntimeException {

    public PasswordNotFoundException() {
        super();
    }
}



@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(SeatTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleNSeatTakenException(SeatTakenException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("The ticket has been already purchased!");
        return errorResponse;
    }
    @ExceptionHandler(TicketNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleTicketNotFoundException(TicketNotFoundException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Wrong token!");
        return errorResponse;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("The number of a row or a column is out of bounds!");
        return errorResponse;
    }
    @ExceptionHandler(PasswordNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResponse handlePasswordNotFoundException(PasswordNotFoundException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("The password is wrong!");
        return errorResponse;
    }
}