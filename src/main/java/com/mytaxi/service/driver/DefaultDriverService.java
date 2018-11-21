package com.mytaxi.service.driver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytaxi.dataaccessobject.DriverRepository;
import com.mytaxi.dataaccessobject.VDriverDetailRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainobject.VDriverDetailDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.car.CarService;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some driver specific things.
 * <p/>
 */
@Service
public class DefaultDriverService implements DriverService, DriverDetailService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultDriverService.class);

    private final DriverRepository driverRepository;
    private final VDriverDetailRepository driverDetailRepository;

    public DefaultDriverService(final DriverRepository driverRepository, final VDriverDetailRepository driverDetailrepository)
    {
        this.driverRepository = driverRepository;
        this.driverDetailRepository=driverDetailrepository;
    }


    /**
     * Selects a driver by id.
     *
     * @param driverId
     * @return found driver
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    public DriverDO find(Long driverId) throws EntityNotFoundException
    {
        return findDriverChecked(driverId);
    }


    /**
     * Creates a new driver.
     *
     * @param driverDO
     * @return
     * @throws ConstraintsViolationException if a driver already exists with the given username, ... .
     */
    @Override
    public DriverDO create(DriverDO driverDO) throws ConstraintsViolationException
    {
        DriverDO driver;
        try
        {
            driver = driverRepository.save(driverDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a driver: {}", driverDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return driver;
    }


    /**
     * Deletes an existing driver by id.
     *
     * @param driverId
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long driverId) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setDeleted(true);
    }


    /**
     * Update the location for a driver.
     *
     * @param driverId
     * @param longitude
     * @param latitude
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setCoordinate(new GeoCoordinate(latitude, longitude));
    }


    /**
     * Find all drivers by online state.
     *
     * @param onlineStatus
     */
    @Override
    public List<DriverDO> find(OnlineStatus onlineStatus)
    {
        return driverRepository.findByOnlineStatus(onlineStatus);
    }


    private DriverDO findDriverChecked(Long driverId) throws EntityNotFoundException
    {
        return driverRepository.findById(driverId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + driverId));
    }

    /**
     * Selects driver with a car.
     *@param licensePlate
     * @param driverDO
     * 
     * */

    @Override
    @Transactional
    public DriverDO selectCar(DriverDO driverDO, CarDO carDO) throws CarAlreadyInUseException
    {
        if (carDO.getIsBooked())
        {
            throw new CarAlreadyInUseException("Car with id " + carDO.getId() + " and license plate number" + carDO.getLicensePlate() + " is already in Use.");
        }
        else
        {
            driverDO.setCarDO(carDO);
            carDO.setIsBooked(Boolean.TRUE);
        }
        return driverDO;
    }


    /**
     *  Unselects driver with a car.
     *
     * @param driverDO
     * @param carDO
     * @return driverDO
     * @throws CarAlreadyInUseException 
     */
    @Override
    @Transactional
    public DriverDO unselectCar(DriverDO driverDO, CarDO carDO) throws CarAlreadyInUseException
    {
        if (driverDO.getCarDO() != null && driverDO.getCarDO().getId() == carDO.getId())
        {
            driverDO.setCarDO(null);
            carDO.setIsBooked(Boolean.FALSE);
        }
        else if(driverDO.getCarDO() == null)
        {
            throw new CarAlreadyInUseException("Driver with id- " + driverDO.getId() + ", needs to select a car before unselecting");
        }
        else
        {
            throw new CarAlreadyInUseException("Car with id " + carDO.getId() + ", is booked by another driver");
        }
        return driverDO;
    }


    /**
     * Selects driver with all car and driver attributes.
     * @param licenseType
     * @return driverDO
     * 
     * */
    @Override
    public List<VDriverDetailDO> find(String licensePlate, OnlineStatus onlineStatus )
    {
        // TODO Auto-generated method stub
        return driverDetailRepository.findDrivers(licensePlate, onlineStatus);
            //, deleted, onlineStatus, username, carId, engineType, isBooked, rating, seatCount, driverId);
    }

}
