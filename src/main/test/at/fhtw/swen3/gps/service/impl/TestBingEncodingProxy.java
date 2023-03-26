package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.exceptions.badexception.BadAddressException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    public void testWithCorrectLatLon() {
        BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
        GeoCoordinate geoCoordinate = null;
        try {
            geoCoordinate = bingEncodingProxy.encodeAddress(Address.builder()
                    .country("Österreich")
                    .city("Wien")
                    .street("Brigittenauer Lände")
                    .postalCode("1200")
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull(geoCoordinate);

        assertEquals(48.2450552, geoCoordinate.getLat());
        assertEquals(16.3686057, geoCoordinate.getLon());
    }
}
