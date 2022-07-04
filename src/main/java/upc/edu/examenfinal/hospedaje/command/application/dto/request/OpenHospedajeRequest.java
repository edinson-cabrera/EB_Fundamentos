package upc.edu.examenfinal.hospedaje.command.application.dto.request;


import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OpenHospedajeRequest {
    @Getter
    private BigDecimal hospedajeId;
    @Getter @NotNull
    private String userId;
    @Getter @NotNull
    private String name;
}
