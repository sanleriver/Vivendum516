package co.com.pascal516.r2dbc.guest.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(value = "GUEST")
public class GuestEntity {
    @Id
    @Column(value = "guest_id")
    private UUID idGuest;
    @Column(value = "guest_name")
    private String guestName;
    @Column(value = "contact_number")
    private String contactNumber;
}
