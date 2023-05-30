package co.com.pascal516.model.booking;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Booking {
    private UUID id;
    private UUID guestId;
    private LocalDate entryDate;
    private LocalDate exitDate;
    private Long value;
}
