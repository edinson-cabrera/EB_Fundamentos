package upc.edu.examenfinal.common.api;

import org.springframework.http.HttpStatus;
import upc.edu.examenfinal.common.application.Error;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ApiController {
    public static ResponseEntity<Object> ok(Object result) {
        return new ResponseEntity(Envelope.ok(result), HttpStatus.OK);
    }

    public static ResponseEntity<Object> created(Object result) {
        return new ResponseEntity(Envelope.ok(result), HttpStatus.CREATED);
    }


    public static ResponseEntity<Object> serverError()
    {
        return new ResponseEntity(Envelope.serverError(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<Object> notFound()
    {
        return new ResponseEntity(Envelope.notFound(), HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<Object> error(List<Error> errors) {
        return new ResponseEntity(Envelope.error(errors), HttpStatus.BAD_REQUEST);
    }
}
