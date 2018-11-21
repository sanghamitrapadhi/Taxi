package com.mytaxi.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mytaxi.domainvalue.CarType;
import com.mytaxi.domainvalue.EngineType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO
{
    @JsonIgnore
    private Long id;

    @NotNull(message = "license plate can not be null!")
    private String licensePlate;

    @NotNull(message = "cartype can not be null!")
    private CarType carType;

    @NotNull(message = "seatCount can not be null!")
    private Integer seatCount;

    @NotNull(message = "engineType can not be null!")
    private EngineType engineType;

    private Boolean convertible;
    

    private CarDTO()
    {
    }


    public CarDTO(Long id, String licensePlate, CarType carType, Integer seatCount, EngineType engineType, Boolean convertible)
    {
        this.id = id;
        this.licensePlate = licensePlate;
        this.carType = carType;
        this.seatCount = seatCount;
        this.engineType = engineType;
        this.convertible = convertible;
        //this.isBooked=false;
    }


    public static CarDTOBuilder newBuilder()
    {
        return new CarDTOBuilder();
    }


    @JsonProperty
    public Long getId()
    {
        return id;
    }


    public String getLicensePlate()
    {
        return licensePlate;
    }


    public CarType getCarType()
    {
        return carType;
    }


    public Integer getSeatCount()
    {
        return seatCount;
    }


    public EngineType getEngineType()
    {
        return engineType;
    }


    public Boolean getConvertible()
    {
        return convertible;
    }
    


    public static class CarDTOBuilder
    {
        private Long id;
        private String licensePlate;
        private CarType carType;
        private Integer seatCount;
        private EngineType engineType;
        private Boolean convertible;


        public CarDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public CarDTOBuilder licensePlate(String licensePlate)
        {
            this.licensePlate = licensePlate;
            return this;
        }


        public CarDTOBuilder setLicensePlate(String licensePlate)
        {
            this.licensePlate = licensePlate;
            return this;
        }


        public CarDTOBuilder setCarType(CarType carType)
        {
            this.carType = carType;
            return this;
        }


        public CarDTOBuilder setSeatCount(Integer seatCount)
        {
            this.seatCount = seatCount;
            return this;
        }


        public CarDTOBuilder setEngineType(EngineType engineType)
        {
            this.engineType = engineType;
            return this;
        }


        public CarDTOBuilder setConvertible(Boolean convertible)
        {
            this.convertible = convertible;
            return this;
        }
        

        public CarDTO createCarDTO()
        {
            return new CarDTO(id, licensePlate, carType, seatCount, engineType, convertible);

        }
    }
}
