package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.exceptions.notemptyexception.FutureHopsNotEmptyException;
import at.fhtw.swen3.services.exceptions.notfoundexception.HopNotFoundException;
import at.fhtw.swen3.services.exceptions.notfoundexception.ParcelNotFoundException;
import at.fhtw.swen3.services.exceptions.badexception.BadAddressException;
import at.fhtw.swen3.services.exceptions.badexception.BadParcelException;
import at.fhtw.swen3.services.exceptions.badexception.BadTrackingIDException;
import at.fhtw.swen3.services.exceptions.duplicationexception.DuplicationTrackingIDException;

public interface ParcelService {

    NewParcelInfo submitNewParcel(Parcel parcel) throws DuplicationTrackingIDException, BadParcelException, BadAddressException, HopNotFoundException;//TASK A

    NewParcelInfo transferExistingParcel(String trackingId, Parcel parcel) throws DuplicationTrackingIDException, BadParcelException, BadAddressException, HopNotFoundException, BadTrackingIDException;//TASK A;//TASK B

    void reportParcelDelivery(String trackingId) throws BadTrackingIDException, FutureHopsNotEmptyException, ParcelNotFoundException; //TASK G

    TrackingInformation trackParcel(String trackingId) throws BadTrackingIDException, ParcelNotFoundException; //TASK H

    void reportParcelArrivalAtHop(String trackingId, String code) throws BadTrackingIDException, ParcelNotFoundException, HopNotFoundException; //TASK F
}
