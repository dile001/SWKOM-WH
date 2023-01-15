package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadAddressException;

import java.io.IOException;

public interface GeoEncodingService {
    GeoCoordinate encodeAddress(Address address) throws BadAddressException;
}
