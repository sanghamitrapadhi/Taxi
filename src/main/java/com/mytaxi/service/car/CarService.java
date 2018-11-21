package com.mytaxi.service.car;

import java.util.List;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.CarType;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

public interface CarService
{

    CarDO find(Long id) throws EntityNotFoundException;
    
    CarDO find(String licensePlate) throws EntityNotFoundException;

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    void delete(String licensePlate) throws EntityNotFoundException;

    void updateRating(String licensePlate, Integer rating) throws EntityNotFoundException;
    
    List<CarDO> find(CarType carType);

    List<CarDO> find(Integer rating);

}
