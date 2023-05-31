package co.com.pascal516.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookingGuestDTO {
    private String name;
    private String contactNumber;
    private String entryDate;
    private String exitDate;
    private Long value;
}
