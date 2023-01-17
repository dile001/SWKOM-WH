package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.exceptions.badexception.BadAddressException;

public interface PredictionService {
    TrackingInformation getTrackingInformation(Recipient recipient, Recipient sender) throws BadAddressException;
}
