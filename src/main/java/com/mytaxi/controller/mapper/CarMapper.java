package com.mytaxi.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;

public class CarMapper
{
    public static CarDO makeCarDO(CarDTO carDTO)
    {
        return new CarDO(carDTO.getCarType(), carDTO.getLicensePlate(),
            carDTO.getSeatCount(), carDTO.getEngineType(), carDTO.getConvertible());
    }

    public static CarDTO makeCarDTO(CarDO carDO)
    {  
        CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder()
            .setId(carDO.getId())
            .setCarType(carDO.getManufacturer())
            .licensePlate(carDO.getLicensePlate())
            .setSeatCount(carDO.getSeatCount())
            .setEngineType(carDO.getEngineType())
            .setConvertible(carDO.getConvertible());
       
        return carDTOBuilder.createCarDTO();
    }


    public static List<CarDTO> makeCarDTOList(Collection<CarDO> cars)
    {
        return cars.stream()
            .map(CarMapper::makeCarDTO)
            .collect(Collectors.toList());
    }
}
