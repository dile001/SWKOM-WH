package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.PredictionService;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadAddressException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class PredictionServiceImpl implements PredictionService {
    private BingEncodingProxy bingEncodingProxy;
    private WarehouseRepository warehouseRepository;

    @Autowired
    public PredictionServiceImpl(BingEncodingProxy bingEncodingProxy, WarehouseRepository warehouseRepository) {
        this.bingEncodingProxy = bingEncodingProxy;
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public TrackingInformation getTrackingInformation(Recipient recipient, Recipient sender) throws BadAddressException {
        List<HopArrival> futureHops;
        GeoCoordinate senderCoordinate;
        GeoCoordinate recipientCoordinate;

        try {
            senderCoordinate = bingEncodingProxy.encodeAddress(Address.builder().city(sender.getCity()).country(sender.getCountry()).postalCode(sender.getPostalCode()).street(sender.getStreet()).build());
        } catch (BadAddressException e) {
            log.error("Bad Address: " + e.getMessage());
            throw e;
        }
        try {
            recipientCoordinate = bingEncodingProxy.encodeAddress(Address.builder().city(recipient.getCity()).country(recipient.getCountry()).postalCode(recipient.getPostalCode()).street(recipient.getStreet()).build());
        } catch (BadAddressException e) {
            log.error("Bad Address: " + e.getMessage());
            throw e;
        }

        List<WarehouseEntity> warehouseList = warehouseRepository.findByLevel(1);
        WarehouseEntity closestToSender = getClosestWarehouse(senderCoordinate, warehouseList);
        WarehouseEntity closestToRecipient = getClosestWarehouse(recipientCoordinate, warehouseList);

        WarehouseEntity rootWarehouse = warehouseRepository.findByLevel(0).get(0);

        futureHops = getPathFromLowestToHighestLevel(closestToSender, rootWarehouse);
        List<HopArrival> pathFromRecipientToRoot = getPathFromLowestToHighestLevel(closestToRecipient, rootWarehouse);
        pathFromRecipientToRoot.remove(pathFromRecipientToRoot.size() - 1);
        while (!pathFromRecipientToRoot.isEmpty()) {
            futureHops.add(pathFromRecipientToRoot.remove(pathFromRecipientToRoot.size() - 1));
        }

        LinkedList<HopArrival> visitedHops = new LinkedList<>();
        return new TrackingInformation().futureHops(futureHops).visitedHops(visitedHops).state(TrackingInformation.StateEnum.PICKUP);
    }

    public List<HopArrival> getPathFromLowestToHighestLevel(WarehouseEntity requestedWarehouse, WarehouseEntity currentWarehouse) {
        List<HopArrival> list;
        if (currentWarehouse == requestedWarehouse) {
            list = new LinkedList<>();
            list.add(new HopArrival().code(currentWarehouse.getNextHops().get(0).getHop().getCode()).dateTime(OffsetDateTime.now()).description(currentWarehouse.getNextHops().get(0).getHop().getDescription()));
            list.add(new HopArrival().code(currentWarehouse.getCode()).description(currentWarehouse.getDescription()).dateTime(OffsetDateTime.now()));
            return list;
        }
        for (WarehouseNextHopsEntity e : currentWarehouse.getNextHops()) {
            if (e.getHop().getHopType().equals("warehouse")) {
                list = getPathFromLowestToHighestLevel(requestedWarehouse, (WarehouseEntity) (e.getHop()));
                if (list != null) {
                    list.add(new HopArrival().code(currentWarehouse.getCode()).dateTime(OffsetDateTime.now()).description(currentWarehouse.getDescription()));
                    return list;
                }
            }
        }
        return null;
    }

    private WarehouseEntity getClosestWarehouse(GeoCoordinate geoCoordinate, List<WarehouseEntity> list) {

        WarehouseEntity closestWarehouse = list.get(0);

        Point sourcePoint = new Point(geoCoordinate.getLat(), geoCoordinate.getLon());
        Point destinationPoint = new Point(closestWarehouse.getLocationCoordinates().getX(), closestWarehouse.getLocationCoordinates().getY());
        double distance = getDistance(sourcePoint, destinationPoint);
        double newDistance;

        for (WarehouseEntity e : list) {
            destinationPoint = new Point(e.getLocationCoordinates().getX(), e.getLocationCoordinates().getY());
            newDistance = getDistance(sourcePoint, destinationPoint);
            if (newDistance < distance) {
                distance = newDistance;
                closestWarehouse = e;
            }
        }

        return closestWarehouse;

    }

    private double getDistance(Point a, Point b) {
        return Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
    }
}
