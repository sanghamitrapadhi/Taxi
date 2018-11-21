package com.mytaxi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytaxi.controller.mapper.CarDriverMapper;
import com.mytaxi.controller.mapper.DriverMapper;
import com.mytaxi.datatransferobject.CarDriverMapperDTO;
import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.datatransferobject.DriverDetailDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainobject.VDriverDetailDO;
import com.mytaxi.domainvalue.EngineType;
import com.mytaxi.domainvalue.MapStatus;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.exception.ForbiddenException;
import com.mytaxi.service.car.CarService;
import com.mytaxi.service.driver.DriverDetailService;
import com.mytaxi.service.driver.DriverService;

/**
 * All operations with a driver will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/drivers")
public class DriverController
{

    private final DriverService driverService;

    private final CarService carService;

    private final DriverDetailService driverDetailService;


    @Autowired
    public DriverController(final DriverService driverService, final CarService carService, DriverDetailService driverDetailService)
    {
        this.driverService = driverService;
        this.carService = carService;
        this.driverDetailService = driverDetailService;
    }


    @GetMapping("/{driverId}")
    public DriverDTO getDriver(@PathVariable long driverId) throws EntityNotFoundException
    {
        return DriverMapper.makeDriverDTO(driverService.find(driverId));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO createDriver(@Valid @RequestBody DriverDTO driverDTO) throws ConstraintsViolationException
    {
        DriverDO driverDO = DriverMapper.makeDriverDO(driverDTO);
        return DriverMapper.makeDriverDTO(driverService.create(driverDO));
    }


    @DeleteMapping("/{driverId}")
    public void deleteDriver(@PathVariable long driverId) throws EntityNotFoundException
    {
        driverService.delete(driverId);
    }


    @PutMapping("/{driverId}")
    public void updateLocation(
        @PathVariable long driverId, @RequestParam double longitude, @RequestParam double latitude)
        throws EntityNotFoundException
    {
        driverService.updateLocation(driverId, longitude, latitude);
    }


    @GetMapping
    public List<DriverDTO> findDrivers(@RequestParam OnlineStatus onlineStatus)
    {
        return DriverMapper.makeDriverDTOList(driverService.find(onlineStatus));
    }


    @PatchMapping("{driverId}")
    public CarDriverMapperDTO mapCar(@Valid @PathVariable long driverId, @RequestParam long carId, @RequestParam MapStatus mapStatus)
        throws EntityNotFoundException, ForbiddenException, CarAlreadyInUseException, ConstraintsViolationException
    {
        DriverDO driverDO = driverService.find(driverId);
        CarDO carDO = carService.find(carId);

        DriverDO driver;

        if (OnlineStatus.ONLINE.equals(driverDO.getOnlineStatus()))
        {
            if (MapStatus.SELECT.equals(mapStatus))
            {
                driver = driverService.selectCar(driverDO, carDO);
            }
            else
            {
                driver = driverService.unselectCar(driverDO, carDO);
            }
        }
        else
        {
            throw new ForbiddenException("Please be online in order to select a car");
        }
        driver = driverService.create(driver);
        CarDriverMapperDTO carDriverDTO = CarDriverMapper.makeCarDriverDTO(driverDO, carDO);
        return carDriverDTO;
    }


    @GetMapping("v1/search")

    public List<DriverDetailDTO> search(@RequestParam(required = false, defaultValue="%") String licensePlate,
            //@RequestParam(required = false, defaultValue="FALSE") String deleted
            @RequestParam(required = false, defaultValue ="ONLINE") OnlineStatus onlineStatus
    //@RequestParam(required = false) String username,
    //@RequestParam(required = false) Long carId,
    //@RequestParam(required = false) EngineType engineType,
    //@RequestParam(required = false) Boolean isBooked,
    //@RequestParam(required = false) Integer rating,
    //@RequestParam(required = false) Integer seatCount
    )
    {
        List<VDriverDetailDO> view =driverDetailService.find(licensePlate, onlineStatus);
        return DriverMapper.makeDriverDetailList(view);
    }

}
