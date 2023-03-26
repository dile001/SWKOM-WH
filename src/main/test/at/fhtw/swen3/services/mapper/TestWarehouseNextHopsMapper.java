package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWarehouseNextHopsMapper {
    Hop dummyHop;
    WarehouseNextHops nextHops;

    void setUp() {
        dummyHop = new Hop().code("wadw").hopType("hophop").description("desc").processingDelayMins(23).locationName("Wien").locationCoordinates(new GeoCoordinate().lon(23.0).lat(44.0));
        nextHops = new WarehouseNextHops().hop(dummyHop).traveltimeMins(2);
    }

    @Test
    void fromDTO() {

        setUp();
        WarehouseNextHopsEntity entity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(nextHops);

        assertEquals(nextHops.getHop(), HopMapper.INSTANCE.entityToDto(entity.getHop()));
        assertEquals(nextHops.getTraveltimeMins(), entity.getTravelTimeMinutes());
    }

    @Test
    void fromEntity() {

        setUp();
        WarehouseNextHopsEntity entity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(nextHops);
        WarehouseNextHops newNextHops = WarehouseNextHopsMapper.INSTANCE.entityToDto(entity);

        assertEquals(entity.getHop(), HopMapper.INSTANCE.dtoToEntity(newNextHops.getHop()));
        assertEquals(entity.getTravelTimeMinutes(), newNextHops.getTraveltimeMins());
    }
}
