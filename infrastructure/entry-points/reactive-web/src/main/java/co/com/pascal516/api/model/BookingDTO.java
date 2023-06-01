package co.com.pascal516.api.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookingDTO {
    private String guestId;
    private LocalDate entryDate;
    private LocalDate exitDate;
    private Long value;
}
