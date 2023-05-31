package co.com.pascal516.api;

import co.com.pascal516.api.model.BookingGuestDTO;
import co.com.pascal516.api.model.ExpenseDTO;
import co.com.pascal516.api.model.RestMapper;
import co.com.pascal516.usecase.bookingscontrol.BookingsControlUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;



@Component
@RequiredArgsConstructor
public class Handler {
    private final BookingsControlUseCase useCase;
    private static final RestMapper mapper = new RestMapper();
    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        return useCase.testing(serverRequest.pathVariable("expenseId"))
                .flatMap(name -> ServerResponse.ok().bodyValue(name))
                .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND).bodyValue("GASTO NO ENCONTRADO"));
    }

    public Mono<ServerResponse> createBookingWithGuest(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(BookingGuestDTO.class)
                .map(mapper::bookingGuestToModel)
                .flatMap(useCase::saveBookingWithGuest)
                .flatMap(message -> ServerResponse.ok().bodyValue(message))
                .doOnError(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> createExpense(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ExpenseDTO.class)
                .map(mapper::expenseToModel)
                .flatMap(useCase::saveExpense)
                .flatMap(message -> ServerResponse.ok().bodyValue(message))
                .doOnError(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }
}
