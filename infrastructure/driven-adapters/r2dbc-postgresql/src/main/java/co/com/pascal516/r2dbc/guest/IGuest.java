package co.com.pascal516.r2dbc.guest;

import co.com.pascal516.model.guest.Guest;
import co.com.pascal516.r2dbc.guest.data.GuestEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

public interface IGuest extends ReactiveCrudRepository<GuestEntity, String> {
    @Transactional
    @Query(value = "INSERT INTO GUEST " +
            "(guest_id, guest_name, contact_number)" +
            " VALUES (:#{#guest.getId()}, :#{#guest.getName()}, :#{#guest.getContactNumber()})" +
            " RETURNING guest_id, guest_name, contact_number")
    Mono<GuestEntity> customSave(@Param("guest") Guest guest);
}
