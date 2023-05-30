package co.com.pascal516.r2dbc.booking;

import co.com.pascal516.r2dbc.booking.data.BookingEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface IBooking extends ReactiveCrudRepository<BookingEntity, UUID> {
}
