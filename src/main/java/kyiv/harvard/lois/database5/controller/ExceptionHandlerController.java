

package kyiv.harvard.lois.database5.controller;



import kyiv.harvard.lois.database5.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ExceptionHandler(GameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String carNotFoundHandler(GameNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SteamNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String driverNotFoundHandler(SteamNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PlatformNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tripNotFoundHandler(PlatformNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SteamAlreadyHasGameException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String personHasBookHandler(SteamAlreadyHasGameException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SteamHasNoGameException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String personHasNoBookHandler(SteamHasNoGameException ex) {
        return ex.getMessage();
    }

}
