package co.com.pascal516.r2dbc.booking;

import co.com.pascal516.model.booking.Booking;
import co.com.pascal516.r2dbc.booking.data.BookingEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.nio.channels.FileChannel;


public interface IBooking extends ReactiveCrudRepository<BookingEntity, String> {
    @Transactional
    @Query(value = "INSERT INTO BOOKING " +
            "(booking_id, guest_id, entry_date, exit_date, value)" +
            " VALUES (:#{#booking.getId()}, :#{#booking.getGuestId()}, :#{#booking.getEntryDate()}," +
            " :#{#booking.getExitDate()}, :#{#booking.getValue()})" +
            " RETURNING booking_id, guest_id, entry_date, exit_date, value")
    Mono<BookingEntity> customSave(@Param("booking") Booking booking);
}
