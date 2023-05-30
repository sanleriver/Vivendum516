package co.com.pascal516.model.booking.gateways;

import co.com.pascal516.model.booking.Booking;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface IBookingRepository {
    Mono<Booking> findById(UUID bookingId);
}
