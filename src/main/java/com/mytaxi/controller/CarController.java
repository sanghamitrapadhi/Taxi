package com.mytaxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.CarType;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.car.CarService;

/**
 * All operations with a car will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/cars")
public class CarController
{

    private final CarService carService;

    @Autowired
    public CarController(final CarService carService)
    {
        this.carService = carService;
    }

    @GetMapping("/licenseplate")
    public CarDTO getCar(@RequestParam("licenseplate") String licensePlate) throws EntityNotFoundException
    {
        return CarMapper.makeCarDTO(carService.find(licensePlate));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO createCar(@Valid @RequestBody CarDTO carDTO) throws ConstraintsViolationException
    {
        CarDO carDO = CarMapper.makeCarDO(carDTO);
        carDTO = CarMapper.makeCarDTO(carDO);
        carService.create(carDO);
        return carDTO;
    }


    @DeleteMapping("/{licenseplate}")
    public void removeCar(@PathVariable("licenseplate") String licensePlate) throws EntityNotFoundException
    {
        carService.delete(licensePlate);
    }


    @PutMapping("/{licenseplate}")
    public void updateRating( @PathVariable("licenseplate")  String licensePlate, @RequestParam Integer rating)
        throws EntityNotFoundException{
        carService.updateRating(licensePlate, rating);
    }


    @GetMapping("/{cartypes}")
    public List<CarDTO> findCars(@RequestParam("cartypes") CarType carType)
    {
        return CarMapper.makeCarDTOList(carService.find(carType));
    }
    
    @GetMapping
    public List<CarDTO> findCars(@RequestParam Integer rating)
    {
        return CarMapper.makeCarDTOList(carService.find(rating));
    }
}
