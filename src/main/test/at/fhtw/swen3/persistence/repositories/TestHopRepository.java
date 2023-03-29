package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.TransferWarehouseEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.TransferWarehouseMapper;
import at.fhtw.swen3.services.mapper.TruckMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.Optional;

@SpringBootTest
public class TestHopRepository {
    @Autowired
    HopRepository hopRepository;

    public Hop hop;
    public Warehouse warehouse;
    public Truck truck;
    public Transferwarehouse transferwarehouse;

    @Test
    public void testDB() {
        hop = new Hop().processingDelayMins(2).code("DWGW").hopType("hophop").description("description").locationName("Wien").locationCoordinates(new GeoCoordinate().lon(42.0).lat(32.0));

        warehouse = new Warehouse().level(1).nextHops(new LinkedList<>()).code("warehouse").hopType("hophop").description("desc").processingDelayMins(23).locationName("Wien").locationCoordinates(new GeoCoordinate().lon(23.0).lat(44.0));

        truck = new Truck().numberPlate("ABCD").regionGeoJson("abcd").code("truck").description("desc").hopType("hophop").locationCoordinates(new GeoCoordinate().lat(32.0).lon(44.0)).locationName("Wien").processingDelayMins(23);

        transferwarehouse = new Transferwarehouse().logisticsPartner("logisticsPartner").logisticsPartnerUrl("logisticsPartnerUrl").regionGeoJson("regionGeoJson").processingDelayMins(23).code("transfer").description("description").hopType("hophop").locationCoordinates(new GeoCoordinate().lon(23.0).lat(43.0)).locationName("Wien");

        HopEntity hopEntity = hopRepository.save(HopMapper.INSTANCE.dtoToEntity(hop));
        WarehouseEntity warehouseEntity = hopRepository.save(WarehouseMapper.INSTANCE.dtoToEntity(warehouse));
        TruckEntity truckEntity = hopRepository.save(TruckMapper.INSTANCE.dtoToEntity(truck));
        TransferWarehouseEntity transferWarehouseEntity = hopRepository.save(TransferWarehouseMapper.INSTANCE.dtoToEntity(transferwarehouse));

        Optional<HopEntity> optionalHopEntity = hopRepository.findById(hopEntity.getId());
        Optional<HopEntity> optionalWarehouseEntity = hopRepository.findById(warehouseEntity.getId());
        Optional<HopEntity> optionalTruckEntity = hopRepository.findById(truckEntity.getId());
        Optional<HopEntity> optionalTransferWarehouseEntity = hopRepository.findById(transferWarehouseEntity.getId());

        assert (optionalHopEntity.isPresent());
        assert (optionalWarehouseEntity.isPresent());
        assert (optionalTruckEntity.isPresent());
        assert (optionalTransferWarehouseEntity.isPresent());

        hopRepository.delete(hopEntity);
        hopRepository.delete(warehouseEntity);
        hopRepository.delete(truckEntity);
        hopRepository.delete(transferWarehouseEntity);
    }
}
