package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadAddressException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBingEncodingProxy {

    @Test
    public void testBingEncodingProxy() {
        BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
        GeoCoordinate geoCoordinate = new GeoCoordinate();
        try {
            geoCoordinate = bingEncodingProxy.encodeAddress(Address.builder()
                    .country("Österreich")
                    .city("Wien")
                    .street("Brigittenauer Lände")
                    .postalCode("1200")
                    .build());
        } catch (BadAddressException e) {
            e.printStackTrace();
        }
        assertNotNull(geoCoordinate);
    }
}
