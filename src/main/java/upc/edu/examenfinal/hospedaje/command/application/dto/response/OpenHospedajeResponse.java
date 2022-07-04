package upc.edu.examenfinal.hospedaje.command.application.dto.response;

import lombok.Value;

@Value
public class OpenHospedajeResponse {
    private String hospedajeId;
    private String userId;
    private String name;
}
