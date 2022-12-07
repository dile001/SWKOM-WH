package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;

public class GeoCoodrinateMapper extends AbstractMapper<GeoCoordinateEntity, GeoCoordinate> {

    @Override
    public GeoCoordinate entityToDto(GeoCoordinateEntity entity) {
        return null;
    }

    @Override
    public GeoCoordinateEntity dtoToEntity(GeoCoordinate o) {
        return null;
    }
}
