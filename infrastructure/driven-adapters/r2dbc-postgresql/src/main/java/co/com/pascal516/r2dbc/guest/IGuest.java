package co.com.pascal516.r2dbc.guest;

import co.com.pascal516.r2dbc.guest.data.GuestEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface IGuest extends ReactiveCrudRepository<GuestEntity, UUID> {
}
