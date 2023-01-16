package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGeoCoordinateMapper {

    @Test
    void testDtoToEntity() {
        GeoCoordinate geoCoordinate = new GeoCoordinate();
        geoCoordinate.setLon(48.0);
        geoCoordinate.setLat(48.0);

        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateMapper.INSTANCE.dtoToEntity(geoCoordinate);

        assertEquals(geoCoordinate.getLon(), geoCoordinateEntity.getLon());
    }

    @Test
    void testEntityToDto() {
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();
        geoCoordinateEntity.setLon(48.0);
        geoCoordinateEntity.setLat(48.0);

        GeoCoordinate geoCoordinate = GeoCoordinateMapper.INSTANCE.entityToDto(geoCoordinateEntity);

        assertEquals(geoCoordinate.getLon(), geoCoordinateEntity.getLon());
    }
}
