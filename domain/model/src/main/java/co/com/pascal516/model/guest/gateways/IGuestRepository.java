package co.com.pascal516.model.guest.gateways;

import co.com.pascal516.model.guest.Guest;
import reactor.core.publisher.Mono;



public interface IGuestRepository {
    Mono<Guest> findById(String guestId);

    Mono<Guest> save(Guest guest);
}
