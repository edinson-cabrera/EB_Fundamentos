package upc.edu.examenfinal.hospedaje.command.application.services;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;
import upc.edu.examenfinal.common.application.Notification;
import upc.edu.examenfinal.common.application.Result;
import upc.edu.examenfinal.common.application.ResultType;
import upc.edu.examenfinal.hospedaje.command.application.commands.CreateHospedaje;
import upc.edu.examenfinal.hospedaje.command.application.dto.request.OpenHospedajeRequest;
import upc.edu.examenfinal.hospedaje.command.application.dto.response.OpenHospedajeResponse;
import upc.edu.examenfinal.hospedaje.command.application.infra.HospedajeRepository;
import upc.edu.examenfinal.hospedaje.command.application.validators.OpenHospedajeValidator;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class HospedajeApplicationService {
    private final CommandGateway commandGateway;
    private final HospedajeRepository hospedajeRepository;
    private final OpenHospedajeValidator openHospedajeValidator;

    public HospedajeApplicationService(CommandGateway commandGateway, HospedajeRepository hospedajeRepository, OpenHospedajeValidator openHospedajeValidator) {
        this.commandGateway = commandGateway;
        this.hospedajeRepository = hospedajeRepository;
        this.openHospedajeValidator = openHospedajeValidator;
    }

    public Result<OpenHospedajeResponse, Notification> Create(OpenHospedajeRequest openHospedajeRequest) throws Exception {
        Notification notification = this.openHospedajeValidator.validate(openHospedajeRequest);
        if (notification.hasErrors()) {
            return Result.failure(notification);
        }
        String hospedajeId = UUID.randomUUID().toString();
        CreateHospedaje createHospedaje = new CreateHospedaje(
                hospedajeId,
                openHospedajeRequest.getUserId(),
                openHospedajeRequest.getName()
        );
        CompletableFuture<Object> future = commandGateway.send(createHospedaje);
        CompletableFuture<ResultType> futureResult = future.handle((ok, ex) -> (ex != null)? ResultType.FAILURE : ResultType.SUCCESS);
        ResultType resultType = futureResult.get();
        if (resultType == ResultType.FAILURE) {
            throw new Exception();
        }
        OpenHospedajeResponse openHospedajeResponse = new OpenHospedajeResponse(
                createHospedaje.getHospedajeId(),
                createHospedaje.getUserId(),
                createHospedaje.getName()
        );
        return Result.success(openHospedajeResponse);
    }


}
