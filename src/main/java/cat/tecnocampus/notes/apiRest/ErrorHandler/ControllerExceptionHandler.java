package cat.tecnocampus.notes.apiRest.ErrorHandler;

import cat.tecnocampus.notes.domain.exception.NotEditableNote;
import cat.tecnocampus.notes.domain.exception.NoteNotOwnedException;
import cat.tecnocampus.notes.persistence.exception.NoteDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import cat.tecnocampus.notes.application.exception.UserNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {UserNotFoundException.class , NoteDoesNotExistException.class})
    public ResponseEntity<String> NotFoundException(RuntimeException ex) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {NotEditableNote.class, NoteNotOwnedException.class})
    public ResponseEntity<String> ConflictException(RuntimeException ex) {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    /*@ExceptionHandler(value = {ErrorValidationHandlingAdvice.class, MethodArgumentNotValidException.class})
    public ResponseEntity<String> resourceNotFoundException(ErrorValidationHandlingAdvice ex, MethodArgumentNotValidException exc) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }*/
}


