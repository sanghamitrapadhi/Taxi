package com.mytaxi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDriverMapperDTO
{

    private DriverDTO driverDTO;
    private CarDTO carDTO;


    private CarDriverMapperDTO()
    {}


    private CarDriverMapperDTO(DriverDTO driverDTO, CarDTO carDTO)
    {
        this.driverDTO = driverDTO;
        this.carDTO = carDTO;
    }


    public static CarDriverDTOBuilder newBuilder()
    {
        return new CarDriverDTOBuilder();
    }


    public CarDTO getCarDTO()
    {
        return carDTO;
    }


    public DriverDTO getDriverDTO()
    {
        return driverDTO;
    }

    public static class CarDriverDTOBuilder
    {
        private DriverDTO driverDTO;
        private CarDTO carDTO;


        public CarDriverDTOBuilder setCarDTO(CarDTO carDTO)
        {
            this.carDTO = carDTO;
            return this;
        }


        public CarDriverDTOBuilder setDriverDTO(DriverDTO driverDTO)
        {
            this.driverDTO = driverDTO;
            return this;
        }


        public CarDriverMapperDTO createDriverDTO()
        {
            return new CarDriverMapperDTO(driverDTO, carDTO);
        }

    }
}
