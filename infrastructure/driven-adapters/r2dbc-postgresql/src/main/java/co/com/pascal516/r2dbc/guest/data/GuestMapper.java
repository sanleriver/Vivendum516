package co.com.pascal516.r2dbc.guest.data;

import co.com.pascal516.model.guest.Guest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GuestMapper {
    public Guest toModel(GuestEntity guestEntity){
        return Guest.builder()
                .id(guestEntity.getIdGuest())
                .name(guestEntity.getGuestName())
                .contactNumber(guestEntity.getContactNumber())
                .build();
    }

    public GuestEntity toEntity(Guest guest){
        return GuestEntity.builder()
                .idGuest(guest.getId())
                .guestName(guest.getName())
                .contactNumber(guest.getContactNumber())
                .build();
    }
}
