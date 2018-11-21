package com.mytaxi.dataaccessobject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.CarType;

/**
 * Database Access Object for car table.
 * <p/>
 */
public interface CarRepository extends CrudRepository<CarDO, Long>
{

    List<CarDO> findByRating(Integer rating);
    
    CarDO findByLicensePlate(String licensePlate);
    
    List<CarDO> findByManufacturer(CarType carType);
}
