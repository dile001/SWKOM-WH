package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import at.fhtw.swen3.services.mapper.TruckMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.mapper.WarehouseNextHopsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.Optional;

@SpringBootTest
public class TestWarehouseNextHopsRepository {
    @Autowired
    WarehouseNextHopsRepository warehouseNextHopsRepository;
    @Autowired
    HopRepository hopRepository;

    public Warehouse warehouse;
    public WarehouseNextHops warehouseNextHops;
    public Truck truck;

    @Test
    public void testDB() {
        warehouse = new Warehouse().level(1).nextHops(new LinkedList<>()).code("warehouse").hopType("hophop").description("desc").processingDelayMins(23).locationName("Wien").locationCoordinates(new GeoCoordinate().lon(23.0).lat(44.0));

        truck = new Truck().numberPlate("ABCD").regionGeoJson("abcd").code("truck").description("desc").hopType("hophop").locationCoordinates(new GeoCoordinate().lat(32.0).lon(44.0)).locationName("Wien").processingDelayMins(23);

        warehouseNextHops = new WarehouseNextHops().hop(truck).traveltimeMins(2);

        WarehouseEntity warehouseEntity = hopRepository.save(WarehouseMapper.INSTANCE.dtoToEntity(warehouse));
        TruckEntity truckEntity = hopRepository.save(TruckMapper.INSTANCE.dtoToEntity(truck));
        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(warehouseNextHops);

        warehouseNextHopsEntity.setHop(warehouseEntity);
        warehouseNextHopsEntity.setHop(truckEntity);

        warehouseNextHopsEntity = warehouseNextHopsRepository.save(warehouseNextHopsEntity);

        Optional<WarehouseNextHopsEntity> optionalWarehouseNextHopsEntity = warehouseNextHopsRepository.findById(warehouseNextHopsEntity.getId());

        assert (optionalWarehouseNextHopsEntity.isPresent());

        warehouseNextHopsRepository.delete(warehouseNextHopsEntity);
        hopRepository.delete(truckEntity);
        hopRepository.delete(warehouseEntity);

    }
}