package com.mytaxi.controller.mapper;

import com.mytaxi.datatransferobject.CarDriverMapperDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;

public class CarDriverMapper
{

    public static CarDriverMapperDTO makeCarDriverDTO(DriverDO driverDO, CarDO carDO)
    {
        CarDriverMapperDTO.CarDriverDTOBuilder carDriverBuilder = CarDriverMapperDTO.newBuilder()
            .setDriverDTO(DriverMapper.makeDriverDTO(driverDO));
        if (carDO != null)
        {
            carDriverBuilder.setCarDTO(CarMapper.makeCarDTO(carDO));
        }

        return carDriverBuilder.createDriverDTO();
    }

}
