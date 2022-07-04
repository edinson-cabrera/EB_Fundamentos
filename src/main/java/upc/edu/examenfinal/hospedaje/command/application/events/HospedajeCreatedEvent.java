package upc.edu.examenfinal.hospedaje.command.application.events;

import lombok.Value;

@Value
public class HospedajeCreatedEvent {
    private String hospedajeId;
    private String userId;
    private String name;
}
