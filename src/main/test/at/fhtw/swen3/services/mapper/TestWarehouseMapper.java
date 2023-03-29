package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TestWarehouseMapper {
    @Test
    void testDTOToEntity() {
        Warehouse warehouse= new Warehouse().level(1).nextHops(new LinkedList<>()).code("wadw").hopType("hophop").description("desc").processingDelayMins(23).locationName("Wien").locationCoordinates(new GeoCoordinate().lon(23.0).lat(44.0));

        Truck truck = new Truck().numberPlate("ABCD").regionGeoJson("abcd").code("awdwd").description("desc").hopType("hophop").locationCoordinates(new GeoCoordinate().lat(32.0).lon(44.0)).locationName("Wien").processingDelayMins(23);

        warehouse.addNextHopsItem(new WarehouseNextHops().traveltimeMins(3).hop(truck));

        WarehouseEntity entity= WarehouseMapper.INSTANCE.dtoToEntity(warehouse);

        assertEquals(warehouse.getCode(), entity.getCode());
        assertEquals(warehouse.getDescription(), entity.getDescription());
        assertEquals(warehouse.getHopType(), entity.getHopType());

        assert(warehouse.getLocationCoordinates().getLon() == entity.getLocationCoordinates().getX());
        assert(warehouse.getLocationCoordinates().getLat() == entity.getLocationCoordinates().getY());

        assertEquals(warehouse.getLocationName(), entity.getLocationName());
        assertEquals(warehouse.getProcessingDelayMins(), entity.getProcessingDelayMins());
        assertEquals(warehouse.getLevel(), entity.getLevel());
        assertEquals(warehouse.getNextHops().get(0), WarehouseNextHopsMapper.INSTANCE.entityToDto(entity.getNextHops().get(0)));
    }

    @Test
    void testEntityToDTO() {
        Warehouse warehouse= new Warehouse().level(1).nextHops(new LinkedList<>()).code("wadw").hopType("hophop").description("desc").processingDelayMins(23).locationName("Wien").locationCoordinates(new GeoCoordinate().lon(23.0).lat(44.0));

        Truck truck = new Truck().numberPlate("ABCD").regionGeoJson("abcd").code("awdwd").description("desc").hopType("hophop").locationCoordinates(new GeoCoordinate().lat(32.0).lon(44.0)).locationName("Wien").processingDelayMins(23);

        warehouse.addNextHopsItem(new WarehouseNextHops().traveltimeMins(3).hop(truck));

        WarehouseEntity entity= WarehouseMapper.INSTANCE.dtoToEntity(warehouse);
        Warehouse newWarehouse= WarehouseMapper.INSTANCE.entityToDto(entity);

        assertEquals(entity.getCode(), newWarehouse.getCode());
        assertEquals(entity.getDescription(), newWarehouse.getDescription());
        assertEquals(entity.getHopType(), newWarehouse.getHopType());

        assert(entity.getLocationCoordinates().getX() == newWarehouse.getLocationCoordinates().getLon());
        assert(entity.getLocationCoordinates().getY() == newWarehouse.getLocationCoordinates().getLat());

        assertEquals(entity.getLocationName(), newWarehouse.getLocationName());
        assertEquals(entity.getProcessingDelayMins(), newWarehouse.getProcessingDelayMins());
        assertEquals(entity.getLevel(), newWarehouse.getLevel());
        assertEquals(WarehouseNextHopsMapper.INSTANCE.entityToDto(entity.getNextHops().get(0)), newWarehouse.getNextHops().get(0));
    }
}
