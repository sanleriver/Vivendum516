package co.com.pascal516.model.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookingGuest {
    private String name;
    private String contactNumber;
    private LocalDate entryDate;
    private LocalDate exitDate;
    private Long value;
}
