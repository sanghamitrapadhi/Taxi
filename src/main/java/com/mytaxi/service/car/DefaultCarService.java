package com.mytaxi.service.car;

import java.time.ZonedDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.CarType;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some car specific things.
 * <p/>
 */
@Service
public class DefaultCarService implements CarService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCarService.class);

    private final CarRepository carRepository ;


    public DefaultCarService(final CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }


    /**
     * Selects a car by id.
     *
     * @param carId
     * @return found driver
     * @throws EntityNotFoundException if no car with the given id was found.
     */
    @Override
    public CarDO find(Long carId) throws EntityNotFoundException
    {
        return findCar(carId);
    }

    /**
     * Selects a car by license plate.
     *
     * @param licensePlate
     * @return found Car
     * @throws EntityNotFoundException if no car with the given string was found.
     */
    @Override
    public CarDO find(String licensePlate) throws EntityNotFoundException
    {
        return findCar(licensePlate);
    }


    /**
     * Creates a new car.
     *
     * @param carDO
     * @return
     * @throws ConstraintsViolationException if a car already exists with the given licenseplate, ... .
     */
    @Override
    public CarDO create(CarDO carDO) throws ConstraintsViolationException
    {
        CarDO car;
        try
        {
            car = carRepository.save(carDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a driver: {}", carDO, e.getCause());
            throw new ConstraintsViolationException(e.getMessage());
        }
        return car;
    }


    /**
     * Deletes an existing car by licensePlate.
     *
     * @param licensePlate
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    @Transactional
    public void delete(String licensePlate) throws EntityNotFoundException
    {
        CarDO carDO = findCar(licensePlate);
        carRepository.delete(carDO);
    }


    /**
     * Update the functioning for a car if it is open for service.
     *
     * @param licensePlate
     * @param rating
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void updateRating(String licensePlate, Integer rating) throws EntityNotFoundException
    {
        CarDO carDO = findCar(licensePlate);
        carDO.setRating(rating);
        carDO.setDateUpdated(ZonedDateTime.now());
    }


    /**
     * Find all functioning cars in the database.
     *
     * @param isFunctioning
     */
    @Override
    public List<CarDO> find(Integer rating)
    {
        return carRepository.findByRating(rating);
    }

    /**
     * Find all cars in the based on car type.
     *
     * @param carType
     */
    @Override
    public List<CarDO> find(CarType carType)
    {
        return carRepository.findByManufacturer(carType);
    }
   
    private CarDO findCar(Long carId) throws EntityNotFoundException
    {
        return carRepository.findById(carId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + carId));
    }

    private CarDO findCar(String licensePlate) throws EntityNotFoundException
    {
        return carRepository.findByLicensePlate(licensePlate);
            //.orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + carId));
    }



}
