package co.com.pascal516.r2dbc.booking;

import co.com.pascal516.model.booking.Booking;
import co.com.pascal516.model.booking.gateways.IBookingRepository;
import co.com.pascal516.r2dbc.booking.data.BookingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Repository
public class BookingRepository implements IBookingRepository {
    private static final Logger log = Logger.getLogger(BookingRepository.class.getName());
    private final IBooking iBooking;
    private static final BookingMapper mapper = new BookingMapper();

    @Override
    public Mono<Booking> findById(String bookingId) {
        log.log(Level.INFO, "FINDING BOOKING: {0}", bookingId);
        return iBooking.findById(bookingId)
                .map(mapper::toModel);
    }
}
