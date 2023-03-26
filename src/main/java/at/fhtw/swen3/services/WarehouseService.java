package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.exceptions.badexception.BadWarehouseException;
import at.fhtw.swen3.services.exceptions.notfoundexception.HierarchyNotFoundException;
import at.fhtw.swen3.services.exceptions.notfoundexception.HopNotFoundException;

public interface WarehouseService {

    Hop getWarehouse(String code) throws HopNotFoundException; //TASK E

    void importWarehouses(Warehouse warehouse) throws BadWarehouseException;// TASK C

    Warehouse exportWarehouses() throws HierarchyNotFoundException; //TASK D

}
