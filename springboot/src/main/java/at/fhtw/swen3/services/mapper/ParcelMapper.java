package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;

public class ParcelMapper extends AbstractMapper<ParcelEntity, Parcel> {
    /*    @Override
        public RecipientEntity recipientEntity(Recipient recipient) {
            return new RecipientEntity(recipient.getName(), recipient.getStreet(), recipient.getPostalCode(), recipient.getCity(), recipient.getCountry());
        }

        @Override
        public HopArrivalEntity hopArrivalEntity(HopArrival hopArrival) {
            return new HopArrivalEntity(hopArrival.getCode(), hopArrival.getDescription() , hopArrival.getDateTime());
        }

        @Override
        public List<HopArrivalEntity> hopArrivalEntities(List<HopArrival> hopArrivalList) {
            List<HopArrivalEntity> hopArrivalEntities = new ArrayList<>();
            for (HopArrival hopArrival : hopArrivalList) {
                hopArrivalEntities.add(hopArrivalEntity(hopArrival));
            }
            return hopArrivalEntities;
        }
    */
    @Override
    public Parcel entityToDto(ParcelEntity entity) {
        return null;
    }

    @Override
    public ParcelEntity dtoToEntity(Parcel parcel) {
        return null;
    }
}
