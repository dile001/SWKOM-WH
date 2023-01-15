package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity.WarehouseNextHopsEntityBuilder;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T18:58:48+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class WarehouseNextHopsMapperImpl implements WarehouseNextHopsMapper {

    @Override
    public WarehouseNextHops entityToDto(WarehouseNextHopsEntity entity) {
        if ( entity == null ) {
            return null;
        }

        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();

        warehouseNextHops.setHop( WarehouseNextHopsMapper.hopEntityToHop( entity.getHop() ) );
        warehouseNextHops.setTraveltimeMins( entity.getTraveltimeMins() );

        return warehouseNextHops;
    }

    @Override
    public WarehouseNextHopsEntity dtoToEntity(WarehouseNextHops o) {
        if ( o == null ) {
            return null;
        }

        WarehouseNextHopsEntityBuilder warehouseNextHopsEntity = WarehouseNextHopsEntity.builder();

        warehouseNextHopsEntity.hop( WarehouseNextHopsMapper.hopToHopEntity( o.getHop() ) );
        warehouseNextHopsEntity.traveltimeMins( o.getTraveltimeMins() );

        return warehouseNextHopsEntity.build();
    }
}