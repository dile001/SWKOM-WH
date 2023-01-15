package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadAddressException;
import org.springframework.context.annotation.Bean;

public interface PredictionService {
    TrackingInformation getTrackingInformation(Recipient recipient, Recipient sender) throws BadAddressException;
}
