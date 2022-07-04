package upc.edu.examenfinal.hospedaje.command.application.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class CreateHospedaje {
    @TargetAggregateIdentifier
    private String hospedajeId;
    private String userId;
    private String name;
}
