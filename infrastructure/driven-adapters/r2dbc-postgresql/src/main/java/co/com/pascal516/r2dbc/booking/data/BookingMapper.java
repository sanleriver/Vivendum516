package co.com.pascal516.r2dbc.booking.data;

import co.com.pascal516.model.booking.Booking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BookingMapper {
    public Booking toModel(BookingEntity bookingEntity){
        return Booking.builder()
                .id(bookingEntity.getIdBooking())
                .guestId(bookingEntity.getIdGuest())
                .entryDate(bookingEntity.getEntryDate())
                .exitDate(bookingEntity.getExitDate())
                .value(bookingEntity.getValue())
                .build();
    }
}
