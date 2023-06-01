package co.com.pascal516.usecase.bookingscontrol;

import co.com.pascal516.model.booking.Booking;
import co.com.pascal516.model.booking.BookingGuest;
import co.com.pascal516.model.booking.gateways.IBookingRepository;
import co.com.pascal516.model.expense.Expense;
import co.com.pascal516.model.expense.gateways.IExpenseRepository;
import co.com.pascal516.model.guest.Guest;
import co.com.pascal516.model.guest.gateways.IGuestRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
                .id(bookingGuest.getGuestId())
                .contactNumber(bookingGuest.getContactNumber())
                .name(bookingGuest.getName())
                .build())
                .flatMap(guest -> iBookingRepository.save(Booking.builder()
                        .id(bookingGuest.getBookingId())
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

    public Mono<String> saveGuest(Guest guest) {
        return iGuestRepository.save(guest)
                .map(guest1 -> "Guest created");
    }

    public Mono<String> saveBooking(Booking booking) {
        return iBookingRepository.save(booking)
                .map(booking1 -> "Booking created");
    }

    public Mono<String> testing(String expenseId){
        var fecha_actual =LocalDateTime.now();
        var zone = ZoneId.of("America/Bogota");
        var zoneOffset = zone.getRules().getOffset(fecha_actual);
        var timestamp = String.valueOf(fecha_actual.toEpochSecond(zoneOffset));
        log.log(Level.INFO, "TIMESTAMP: {0}", timestamp);
        return iExpenseRepository.findById(expenseId)
                .flatMap(expense -> iBookingRepository.findById(expense.getBookingId()))
                .flatMap(booking -> iGuestRepository.findById(booking.getGuestId()))
                .map(Guest::getName)
                .doOnNext(name -> log.log(Level.INFO, "GUEST FOUND: {0}", name));
    }

    public Flux<BookingGuest> getBookings() {
        return iBookingRepository.getAllBookings();
    }

    public Flux<Expense> getExpenseByBooking(String bookingId) {
        return iExpenseRepository.findByBookingId(bookingId);
    }
}
