package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.exceptions.bad_____exception.BadWarehouseException;
import at.fhtw.swen3.services.exceptions._____notfoundexception.HierarchyNotFoundException;
import at.fhtw.swen3.services.exceptions._____notfoundexception.HopNotFoundException;

public interface WarehouseService {

    Hop getWarehouse(String code) throws HopNotFoundException; //TASK E

    void importWarehouses(Warehouse warehouse) throws BadWarehouseException;// TASK C

    Warehouse exportWarehouses() throws HierarchyNotFoundException; //TASK D

}
