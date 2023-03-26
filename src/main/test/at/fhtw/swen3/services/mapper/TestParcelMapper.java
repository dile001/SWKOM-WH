package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParcelMapper {
    NewParcelInfo newParcelInfo;
    Recipient recipient;
    Parcel parcel;
    TrackingInformation trackingInformation;

    @Test
    void testParcelMapper() {
        newParcelInfo = new NewParcelInfo().trackingId("1234");

        recipient = new Recipient();
        recipient.setCity("Wien");
        recipient.setPostalCode("1200");
        recipient.setStreet("Brigittenauer Lände");
        recipient.setName("Vasilije");
        recipient.setCountry("Österreich");

        parcel = new Parcel().weight(10.0f).sender(recipient).recipient(recipient);

        trackingInformation = new TrackingInformation().state(TrackingInformation.StateEnum.DELIVERED).visitedHops(new ArrayList<>()).futureHops(new ArrayList<>());
        trackingInformation.addFutureHopsItem(new HopArrival().code("WDABWATA"));
        trackingInformation.addVisitedHopsItem(new HopArrival().code("WDABWATA"));

        ParcelEntity entity = ParcelMapper.INSTANCE.dtoToEntity(newParcelInfo, parcel, trackingInformation);

        assertEquals(newParcelInfo.getTrackingId(), entity.getTrackingId());
        assert (Objects.equals(parcel.getWeight(), entity.getWeight()));
        assertEquals(parcel.getSender(), RecipientMapper.INSTANCE.entityToDto(entity.getSender()));
        assertEquals(parcel.getRecipient(), RecipientMapper.INSTANCE.entityToDto(entity.getRecipient()));
        assertEquals(trackingInformation.getState(), entity.getState());
        assertEquals(trackingInformation.getVisitedHops().get(0), HopArrivalMapper.INSTANCE.entityToDto(entity.getVisitedHops().get(0)));
        assertEquals(trackingInformation.getFutureHops().get(0), HopArrivalMapper.INSTANCE.entityToDto(entity.getVisitedHops().get(0)));
    }
}
