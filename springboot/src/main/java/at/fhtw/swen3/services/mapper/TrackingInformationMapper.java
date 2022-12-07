package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.TrackingInformationEntity;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;

public class TrackingInformationMapper extends AbstractMapper<TrackingInformationEntity, TrackingInformation> {

    @Override
    public TrackingInformation entityToDto(TrackingInformationEntity entity) {
        return null;
    }

    @Override
    public TrackingInformationEntity dtoToEntity(TrackingInformation o) {
        return null;
    }
}