package co.com.pascal516.usecase.bookingscontrol;

import co.com.pascal516.model.booking.gateways.IBookingRepository;
import co.com.pascal516.model.expense.gateways.IExpenseRepository;
import co.com.pascal516.model.guest.Guest;
import co.com.pascal516.model.guest.gateways.IGuestRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class BookingsControlUseCase {
    private static final Logger log = Logger.getLogger(BookingsControlUseCase.class.getName());
    private final IExpenseRepository iExpenseRepository;
    private final IBookingRepository iBookingRepository;
    private final IGuestRepository iGuestRepository;

    public Mono<String> testing(String expenseId){
        return iExpenseRepository.findById(expenseId)
                .flatMap(expense -> iBookingRepository.findById(expense.getBookingId()))
                .flatMap(booking -> iGuestRepository.findById(booking.getGuestId()))
                .map(Guest::getName)
                .doOnNext(name -> log.log(Level.INFO, "GUEST FOUND: {0}", name));
    }
}
