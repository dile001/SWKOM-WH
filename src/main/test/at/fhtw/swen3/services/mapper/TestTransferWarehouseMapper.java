package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTransferWarehouseMapper {
    Transferwarehouse transferwarehouse = new Transferwarehouse().logisticsPartner("logisticsPartner").logisticsPartnerUrl("logisticsPartnerUrl").regionGeoJson("regionGeoJson").processingDelayMins(23).code("awdwad").description("description").hopType("hophop").locationCoordinates(new GeoCoordinate().lon(23.0).lat(43.0)).locationName("Wien");

    @Test
    void testDTOToEntity() {
        TransferWarehouseEntity entity = TransferWarehouseMapper.INSTANCE.dtoToEntity(transferwarehouse);
        assertEquals(transferwarehouse.getCode(), entity.getCode());
        assertEquals(transferwarehouse.getDescription(), entity.getDescription());
        assertEquals(transferwarehouse.getHopType(), entity.getHopType());

        assert (transferwarehouse.getLocationCoordinates().getLon() == entity.getLocationCoordinates().getX());
        assert (transferwarehouse.getLocationCoordinates().getLat() == entity.getLocationCoordinates().getY());

        assertEquals(transferwarehouse.getLocationName(), entity.getLocationName());
        assertEquals(transferwarehouse.getProcessingDelayMins(), entity.getProcessingDelayMins());
        assertEquals(transferwarehouse.getLogisticsPartnerUrl(), entity.getLogisticsPartnerUrl());
        assertEquals(transferwarehouse.getLogisticsPartner(), entity.getLogisticsPartner());
        assertEquals(transferwarehouse.getRegionGeoJson(), entity.getRegionGeoJson());
    }

    @Test
    void testEntityToDTO() {
        TransferWarehouseEntity entity = TransferWarehouseMapper.INSTANCE.dtoToEntity(transferwarehouse);
        Transferwarehouse newWarehouse = TransferWarehouseMapper.INSTANCE.entityToDto(entity);
        assertEquals(entity.getCode(), newWarehouse.getCode());
        assertEquals(entity.getDescription(), newWarehouse.getDescription());
        assertEquals(entity.getHopType(), newWarehouse.getHopType());

        assert (entity.getLocationCoordinates().getX() == newWarehouse.getLocationCoordinates().getLon());
        assert (entity.getLocationCoordinates().getY() == newWarehouse.getLocationCoordinates().getLat());

        assertEquals(entity.getLocationName(), newWarehouse.getLocationName());
        assertEquals(entity.getProcessingDelayMins(), newWarehouse.getProcessingDelayMins());
        assertEquals(entity.getLogisticsPartnerUrl(), newWarehouse.getLogisticsPartnerUrl());
        assertEquals(entity.getLogisticsPartner(), newWarehouse.getLogisticsPartner());
        assertEquals(entity.getRegionGeoJson(), newWarehouse.getRegionGeoJson());

    }
}
