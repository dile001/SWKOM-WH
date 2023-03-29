package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.Test;
import org.springframework.data.geo.Point;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCoordinateToPointMapper {
    private final Point point = new Point(42,23);

    @Test
    void testDTOToEntity() {
        assertEquals(point.getX(), CoordinateToPointMapper.pointToGeoCoordinate(point).getLon());
    }

    @Test
    void testEntityToDTO() {
        GeoCoordinate coordinate = CoordinateToPointMapper.pointToGeoCoordinate(point);
        assertEquals(coordinate.getLon(), CoordinateToPointMapper.geoCoordinateToPoint(coordinate).getX());
    }
}