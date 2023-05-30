package co.com.pascal516.r2dbc.booking.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(value = "BOOKING")
public class BookingEntity {
    @Id
    @Column(value = "booking_id")
    private String idBooking;
    @Column(value = "guest_id")
    private String idGuest;
    @Column(value = "entry_date")
    private LocalDate entryDate;
    @Column(value = "exit_date")
    private LocalDate exitDate;
    @Column(value = "value")
    private Long value;
}
