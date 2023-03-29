package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.Optional;

@SpringBootTest
public class TestWarehouseRepository {
    @Autowired
    WarehouseRepository repository;

    public Warehouse warehouse;

    @Test
    public void testDB() {
        warehouse = new Warehouse().level(1).nextHops(new LinkedList<>()).code("warehouse").hopType("hophop").description("desc").processingDelayMins(23).locationName("Wien").locationCoordinates(new GeoCoordinate().lon(23.0).lat(44.0));

        WarehouseEntity warehouseEntity = repository.save(WarehouseMapper.INSTANCE.dtoToEntity(warehouse));

        Optional<WarehouseEntity> optionalWarehouseEntity = repository.findById(warehouseEntity.getId());

        assert (optionalWarehouseEntity.isPresent());

        repository.delete(warehouseEntity);
    }
}
