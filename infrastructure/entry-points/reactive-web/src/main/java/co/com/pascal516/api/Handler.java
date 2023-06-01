package co.com.pascal516.api;

import co.com.pascal516.api.model.*;
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

    public Mono<ServerResponse> createGuest(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(GuestDTO.class)
                .map(mapper::guestToModel)
                .flatMap(useCase::saveGuest)
                .flatMap(message -> ServerResponse.ok().bodyValue(message))
                .doOnError(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> createBooking(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(BookingDTO.class)
                .map(mapper::bookingToModel)
                .flatMap(useCase::saveBooking)
                .flatMap(message -> ServerResponse.ok().bodyValue(message))
                .doOnError(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> getBookings(ServerRequest serverRequest) {
        return useCase.getBookings()
                .collectList()
                .flatMap(bookingGuest -> ServerResponse.ok().bodyValue(bookingGuest));
    }

    public Mono<ServerResponse> getExpensesByBooking(ServerRequest serverRequest) {
        return useCase.getExpenseByBooking(serverRequest.pathVariable("bookingId"))
                .collectList()
                .flatMap(expenses -> ServerResponse.ok().bodyValue(expenses));
    }
}
