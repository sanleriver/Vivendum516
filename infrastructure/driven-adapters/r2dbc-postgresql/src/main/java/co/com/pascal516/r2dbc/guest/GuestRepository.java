package co.com.pascal516.r2dbc.guest;

import co.com.pascal516.model.guest.Guest;
import co.com.pascal516.model.guest.gateways.IGuestRepository;
import co.com.pascal516.r2dbc.guest.data.GuestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Repository
public class GuestRepository implements IGuestRepository {
    private static final Logger log = Logger.getLogger(GuestRepository.class.getName());
    private final IGuest iGuest;
    private static final GuestMapper mapper = new GuestMapper();

    @Override
    public Mono<Guest> findById(String guestId) {
        log.log(Level.INFO, "FINDING GUEST: {0}", guestId);
        return iGuest.findById(guestId)
                .map(mapper::toModel);
    }
}
