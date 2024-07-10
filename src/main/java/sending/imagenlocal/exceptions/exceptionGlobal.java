package sending.imagenlocal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sending.imagenlocal.dto.ResponseDTO;

import java.time.LocalDateTime;

@ControllerAdvice
@RestControllerAdvice
public class exceptionGlobal {

    @ExceptionHandler(LimitExceededException.class)
    public ResponseEntity<ResponseDTO> limitExcededException(LimitExceededException exception){
        return new ResponseEntity<>(
          ResponseDTO.builder()
                  .date(LocalDateTime.now())
                  .message(exception.getMessage())
                  .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDTO> limitExcededException(NotFoundException exception){
        return new ResponseEntity<>(
          ResponseDTO.builder()
                  .date(LocalDateTime.now())
                  .message(exception.getMessage())
                  .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ResourceInvalidException.class)
    public ResponseEntity<ResponseDTO> limitExcededException(ResourceInvalidException exception){
        return new ResponseEntity<>(
          ResponseDTO.builder()
                  .date(LocalDateTime.now())
                  .message(exception.getMessage())
                  .build(),
                HttpStatus.BAD_REQUEST
        );
    }


}
