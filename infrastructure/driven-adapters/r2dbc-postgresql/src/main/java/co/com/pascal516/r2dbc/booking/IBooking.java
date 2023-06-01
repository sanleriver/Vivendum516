package co.com.pascal516.r2dbc.booking;

import co.com.pascal516.model.booking.Booking;
import co.com.pascal516.model.booking.BookingGuest;
import co.com.pascal516.r2dbc.booking.data.BookingEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
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

    @Query(value = "SELECT bk.booking_id, g.guest_id, g.guest_name as name, g.contact_number, " +
            "bk.entry_date, bk.exit_date, bk.value, t.expenses " +
            "FROM u410847206_pascal.BOOKING bk " +
            "INNER JOIN (SELECT SUM(e.expense_value) as expenses, e.booking_id " +
            "FROM EXPENSE e GROUP BY e.booking_id) t " +
            "ON t.booking_id = bk.booking_id " +
            "LEFT JOIN GUEST g ON g.guest_id = bk.guest_id " +
            "ORDER BY bk.entry_date")
    Flux<BookingGuest> findAllCompleteBookings();
}
