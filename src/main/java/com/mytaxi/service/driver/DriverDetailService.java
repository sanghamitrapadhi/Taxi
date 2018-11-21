package com.mytaxi.service.driver;

import java.util.List;

import com.mytaxi.domainobject.VDriverDetailDO;
import com.mytaxi.domainvalue.OnlineStatus;

public interface DriverDetailService
{
    List<VDriverDetailDO> find(String license, OnlineStatus onlineStatus);

}
