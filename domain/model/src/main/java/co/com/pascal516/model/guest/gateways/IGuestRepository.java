package co.com.pascal516.model.guest.gateways;

import co.com.pascal516.model.guest.Guest;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface IGuestRepository {
    Mono<Guest> findById(UUID guestId);
}
