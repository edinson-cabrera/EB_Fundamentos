package upc.edu.examenfinal.hospedaje.command.domain;

import org.axonframework.spring.stereotype.Aggregate;
import upc.edu.examenfinal.hospedaje.command.application.commands.CreateHospedaje;
import upc.edu.examenfinal.hospedaje.command.application.events.HospedajeCreatedEvent;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;
@Aggregate
public class Hospedaje {
    private String  hospedajeId;
    private String userId;
    private String name;

    public Hospedaje() {}

    public Hospedaje(CreateHospedaje command) {
        apply(
                new HospedajeCreatedEvent(
                        command.getHospedajeId(),
                        command.getUserId(),
                        command.getName()
                )
        );
    }


}
