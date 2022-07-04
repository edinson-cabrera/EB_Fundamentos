package upc.edu.examenfinal.hospedaje.command.application.validators;

import org.springframework.stereotype.Component;
import upc.edu.examenfinal.common.application.Notification;
import upc.edu.examenfinal.hospedaje.command.application.dto.request.OpenHospedajeRequest;
import upc.edu.examenfinal.hospedaje.command.application.infra.HospedajeRepository;

@Component
public class OpenHospedajeValidator {
    private final HospedajeRepository hospedajeRepository;

    public OpenHospedajeValidator(HospedajeRepository hospedajeRepository) {
        this.hospedajeRepository = hospedajeRepository;
    }

    public Notification validate(OpenHospedajeRequest openHospedajeRequest) {
        Notification notification = new Notification();
        String user = openHospedajeRequest.getUserId();
        if(user.isEmpty()) {
            notification.addError("El id del usuario es requerido");
        }
        String hospedajeId = openHospedajeRequest.getUserId().trim();
        if(hospedajeId.isEmpty()) {
            notification.addError("El id del usuario es requerido");
        }
        String text = openHospedajeRequest.getName();
        if(text.isEmpty()) {
            notification.addError("El nombre del usuario es requerido");
        }
        if (notification.hasErrors()){
            return notification;
        }
        return notification;
    }
}
