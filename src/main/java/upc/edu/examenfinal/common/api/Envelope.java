package upc.edu.examenfinal.common.api;

import upc.edu.examenfinal.common.application.Error;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Envelope {
    private Object result;
    private List<Error> errors;

    private Envelope(Object result, List<Error> errors) {
        this.result = result;
        this.errors = errors;
    }

    public static Envelope ok(Object result)
    {
        return new Envelope(result, new ArrayList<Error>());
    }


    public static Envelope serverError()
    {
        List<Error> errors = new ArrayList<Error>();
        Error error = new Error("Internal Server Error", null);
        errors.add(error);
        return new Envelope(null, errors);
    }

    public static Envelope notFound()
    {
        List<Error> errors = new ArrayList<Error>();
        Error error = new Error("entity not found", null);
        errors.add(error);
        return new Envelope(null, errors);
    }

    public static Envelope error(List<Error> errors) {
        if (errors == null) errors = new ArrayList<>();
        return new Envelope(null, errors);
    }
}
