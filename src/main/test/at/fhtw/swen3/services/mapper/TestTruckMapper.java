package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Truck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTruckMapper {
    Truck truck = new Truck().numberPlate("ABCD").regionGeoJson("abcd").code("awdwd").description("desc").hopType("hophop").locationCoordinates(new GeoCoordinate().lat(32.0).lon(44.0)).locationName("Wien").processingDelayMins(23);

    @Test
    void testDTOToEntity() {
        TruckEntity entity= TruckMapper.INSTANCE.dtoToEntity(truck);

        assertEquals(truck.getCode(), entity.getCode());
        assertEquals(truck.getDescription(), entity.getDescription());
        assertEquals(truck.getHopType(), entity.getHopType());

        assert(truck.getLocationCoordinates().getLon() == entity.getLocationCoordinates().getX());
        assert(truck.getLocationCoordinates().getLat() == entity.getLocationCoordinates().getY());

        assertEquals(truck.getLocationName(), entity.getLocationName());
        assertEquals(truck.getProcessingDelayMins(), entity.getProcessingDelayMins());
        assertEquals(truck.getRegionGeoJson(), entity.getRegionGeoJson());
        assertEquals(truck.getNumberPlate(), entity.getNumberPlate());
    }

    @Test
    void testEntityToDTO() {
        TruckEntity entity= TruckMapper.INSTANCE.dtoToEntity(truck);
        Truck newTruck= TruckMapper.INSTANCE.entityToDto(entity);

        assertEquals(entity.getCode(), newTruck.getCode());
        assertEquals(entity.getDescription(), newTruck.getDescription());
        assertEquals(entity.getHopType(), newTruck.getHopType());

        assert(entity.getLocationCoordinates().getX() == newTruck.getLocationCoordinates().getLon());
        assert(entity.getLocationCoordinates().getY() == newTruck.getLocationCoordinates().getLat());

        assertEquals(entity.getLocationName(), newTruck.getLocationName());
        assertEquals(entity.getProcessingDelayMins(), newTruck.getProcessingDelayMins());
        assertEquals(entity.getRegionGeoJson(), newTruck.getRegionGeoJson());
        assertEquals(entity.getNumberPlate(), newTruck.getNumberPlate());
    }
}
