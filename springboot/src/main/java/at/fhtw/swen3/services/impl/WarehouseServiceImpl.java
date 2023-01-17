package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseNextHopsRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.exceptions.notfoundexception.HierarchyNotFoundException;
import at.fhtw.swen3.services.exceptions.notfoundexception.HopNotFoundException;
import at.fhtw.swen3.services.exceptions.badexception.BadWarehouseException;
import at.fhtw.swen3.services.mapper.HopMapper;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import at.fhtw.swen3.services.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.List;

@Service
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {

    private final HopRepository hopRepository;
    private final WarehouseNextHopsRepository warehouseNextHopsRepository;
    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(HopRepository hopRepository, WarehouseNextHopsRepository warehouseNextHopsRepository, WarehouseRepository warehouseRepository) {
        this.hopRepository = hopRepository;
        this.warehouseNextHopsRepository = warehouseNextHopsRepository;
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public void importWarehouses(Warehouse warehouse) throws BadWarehouseException {
        try {
            Validator.validate(warehouse);
        } catch (ValidationException e) {
            log.error("Error with validation:\n" + e.getMessage());
            throw new BadWarehouseException("Given warehouse hierarchy failed validation");
        }
        hopRepository.deleteAll();
        saveWarehouseRecursive(WarehouseMapper.INSTANCE.dtoToEntity(warehouse));
    }

    @Override
    @Transactional
    public Warehouse exportWarehouses() throws HierarchyNotFoundException {
        List<WarehouseEntity> entityList = warehouseRepository.findByLevel(0);
        if (entityList.isEmpty()) {
            throw new HierarchyNotFoundException("Hierarchy not found");
        }
        return WarehouseMapper.INSTANCE.entityToDto(entityList.get(0));
    }

    @Override
    @Transactional
    public Hop getWarehouse(String code) throws HopNotFoundException {
        HopEntity hopEntity;
        try {
            hopEntity = hopRepository.findByCode(code).get(0);
        } catch (IndexOutOfBoundsException e) {
            log.error("Wrong code");
            throw new HopNotFoundException("Hop " + code + " does not exist");
        }
        return HopMapper.INSTANCE.entityToDto(hopEntity);
    }

    private HopEntity saveWarehouseRecursive(HopEntity hopEntity) {
        if (hopEntity.getClass() != WarehouseEntity.class) {
            return hopRepository.save(hopEntity);
        } else {
            WarehouseEntity entity = (WarehouseEntity) (hopEntity);
            for (WarehouseNextHopsEntity nextHopsEntity : entity.getNextHops()) {
                nextHopsEntity.setHop(saveWarehouseRecursive(nextHopsEntity.getHop()));
                warehouseNextHopsRepository.save(nextHopsEntity);
            }
            return hopRepository.save(entity);
        }
    }
}
