package co.com.pascal516.api.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class GuestDTO {
    private String name;
    private String contactNumber;
}
