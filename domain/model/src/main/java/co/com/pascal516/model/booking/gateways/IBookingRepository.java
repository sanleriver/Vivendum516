package co.com.pascal516.model.booking.gateways;

import co.com.pascal516.model.booking.Booking;
import co.com.pascal516.model.booking.BookingGuest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface IBookingRepository {
    Mono<Booking> findById(String bookingId);

    Mono<Booking> save(Booking booking);

    Flux<BookingGuest> getAllBookings();
}
