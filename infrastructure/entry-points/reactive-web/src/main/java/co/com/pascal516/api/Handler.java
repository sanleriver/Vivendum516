package co.com.pascal516.api;

import co.com.pascal516.usecase.bookingscontrol.BookingsControlUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;



@Component
@RequiredArgsConstructor
public class Handler {
private  final BookingsControlUseCase useCase;
    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        return useCase.testing(serverRequest.pathVariable("expenseId"))
                .flatMap(name -> ServerResponse.ok().bodyValue(name))
                .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND).bodyValue("GASTO NO ENCONTRADO"));
    }
}
