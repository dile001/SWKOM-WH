package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.exceptions._____notemptyexception.FutureHopsNotEmptyException;
import at.fhtw.swen3.services.exceptions._____notfoundexception.HopNotFoundException;
import at.fhtw.swen3.services.exceptions._____notfoundexception.ParcelNotFoundException;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadAddressException;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadParcelException;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadTrackingIDException;
import at.fhtw.swen3.services.exceptions.duplication_____exception.DuplicationTrackingIDException;

public interface ParcelService {

    NewParcelInfo submitNewParcel(Parcel parcel) throws DuplicationTrackingIDException, BadParcelException, BadAddressException, HopNotFoundException;//TASK A

    NewParcelInfo transferExistingParcel(String trackingId, Parcel parcel) throws DuplicationTrackingIDException, BadParcelException, BadAddressException, HopNotFoundException, BadTrackingIDException;//TASK A;//TASK B

    void reportParcelDelivery(String trackingId) throws BadTrackingIDException, FutureHopsNotEmptyException, ParcelNotFoundException; //TASK G

    TrackingInformation trackParcel(String trackingId) throws BadTrackingIDException, ParcelNotFoundException; //TASK H

    void reportParcelArrivalAtHop(String trackingId, String code) throws BadTrackingIDException, ParcelNotFoundException, HopNotFoundException; //TASK F
}
