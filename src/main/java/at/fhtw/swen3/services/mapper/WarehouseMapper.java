package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.LinkedList;
import java.util.List;

@Mapper
public interface WarehouseMapper extends CoordinateToPointMapper{
    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);

    @Named("nextHopsDtoToEntity")
    static List<WarehouseNextHopsEntity> nextHopsDtoToEntity(List<WarehouseNextHops> list){
        LinkedList<WarehouseNextHopsEntity> newList= new LinkedList<>();
        for(WarehouseNextHops i : list){
            newList.add(WarehouseNextHopsMapper.INSTANCE.dtoToEntity(i));
        }
        return newList;
    }

    @Named("nextHopsEntityToDto")
    static List<WarehouseNextHops> nextHopsEntityToDto(List<WarehouseNextHopsEntity> list){
        LinkedList<WarehouseNextHops> newList= new LinkedList<>();
        for(WarehouseNextHopsEntity i : list){
            newList.add(WarehouseNextHopsMapper.INSTANCE.entityToDto(i));
        }
        return newList;
    }

    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "pointToGeoCoordinate")
    @Mapping(source = "nextHops", target = "nextHops", qualifiedByName = "nextHopsEntityToDto")
    Warehouse entityToDto(WarehouseEntity entity);

    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "geoCoordinateToPoint")
    @Mapping(source = "nextHops", target = "nextHops", qualifiedByName = "nextHopsDtoToEntity")
    WarehouseEntity dtoToEntity(Warehouse o);
}