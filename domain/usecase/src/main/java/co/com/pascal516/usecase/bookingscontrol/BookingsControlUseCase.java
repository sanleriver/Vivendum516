package co.com.pascal516.usecase.bookingscontrol;

import co.com.pascal516.model.booking.Booking;
import co.com.pascal516.model.booking.BookingGuest;
import co.com.pascal516.model.booking.gateways.IBookingRepository;
import co.com.pascal516.model.expense.Expense;
import co.com.pascal516.model.expense.gateways.IExpenseRepository;
import co.com.pascal516.model.guest.Guest;
import co.com.pascal516.model.guest.gateways.IGuestRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class BookingsControlUseCase {
    private static final Logger log = Logger.getLogger(BookingsControlUseCase.class.getName());
    private final IExpenseRepository iExpenseRepository;
    private final IBookingRepository iBookingRepository;
    private final IGuestRepository iGuestRepository;

    public Mono<String> saveBookingWithGuest(BookingGuest bookingGuest){
        return iGuestRepository.save(Guest.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .contactNumber(bookingGuest.getContactNumber())
                .name(bookingGuest.getName())
                .build())
                .flatMap(guest -> iBookingRepository.save(Booking.builder()
                        .id(String.valueOf(UUID.randomUUID()))
                        .guestId(guest.getId())
                        .entryDate(bookingGuest.getEntryDate())
                        .exitDate(bookingGuest.getExitDate())
                        .value(bookingGuest.getValue())
                        .build()))
                .map(booking -> "Booking and guest created");
    }

    public Mono<String> saveExpense(Expense expense){
        return iExpenseRepository.save(expense)
                .map(expense1 -> "Expense created");
    }

    public Mono<String> testing(String expenseId){
        return iExpenseRepository.findById(expenseId)
                .flatMap(expense -> iBookingRepository.findById(expense.getBookingId()))
                .flatMap(booking -> iGuestRepository.findById(booking.getGuestId()))
                .map(Guest::getName)
                .doOnNext(name -> log.log(Level.INFO, "GUEST FOUND: {0}", name));
    }
}
