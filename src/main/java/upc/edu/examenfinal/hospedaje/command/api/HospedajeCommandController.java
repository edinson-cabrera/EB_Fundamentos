package upc.edu.examenfinal.hospedaje.command.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upc.edu.examenfinal.common.api.ApiController;
import upc.edu.examenfinal.common.application.Notification;
import upc.edu.examenfinal.common.application.Result;
import upc.edu.examenfinal.hospedaje.command.application.dto.request.OpenHospedajeRequest;
import upc.edu.examenfinal.hospedaje.command.application.dto.response.OpenHospedajeResponse;
import upc.edu.examenfinal.hospedaje.command.application.services.HospedajeApplicationService;

@RestController
@RequestMapping("/api/hospedaje")
@Tag(name="Hospedaje")
public class HospedajeCommandController {
    private final CommandGateway commandGateway;
    private final HospedajeApplicationService hospedajeApplicationService;

    public HospedajeCommandController(CommandGateway commandGateway, HospedajeApplicationService hospedajeApplicationService) {
        this.commandGateway = commandGateway;
        this.hospedajeApplicationService = hospedajeApplicationService;
    }

    @PostMapping("")
    public ResponseEntity<Object> createHospedaje(@Validated @RequestBody OpenHospedajeRequest openHospedajeRequest) {
        try {
            Result<OpenHospedajeResponse, Notification> result = hospedajeApplicationService.Create(openHospedajeRequest);
            if (result.isSuccess()) {
                return ApiController.created(result.getSuccess());
            }
            return ApiController.error(result.getFailure().getErrors());
        } catch (Exception e) {
            return ApiController.serverError();
        }
    }
}
