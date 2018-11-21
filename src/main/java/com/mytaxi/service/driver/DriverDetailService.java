package com.mytaxi.service.driver;

import java.util.List;

import com.mytaxi.domainobject.VDriverDetailDO;

public interface DriverDetailService
{
    List<VDriverDetailDO> find(String license, String deleted, String onlineStatus, String username, String carId,
        String engineType, String isBooked, String rating, String seatCount);

}
