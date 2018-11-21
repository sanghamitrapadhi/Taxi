package com.mytaxi.datatransferobject;

import java.time.ZonedDateTime;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mytaxi.domainvalue.EngineType;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverDetailDTO
{
    @Id
    @JsonIgnore
    private Long driverId;
    private String username;
    private String password;
    private GeoCoordinate coordinate;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateCoordinateUpdated;
    private Boolean deleted;
    private OnlineStatus onlineStatus;
    private EngineType engineType;
    private Long carId;
    private Boolean isBooked;
    private String licensePlate;
    private Integer rating;
    private Integer seatCount;


    private DriverDetailDTO()
    {}


    public DriverDetailDTO(
        Long driverId, String username, String password, GeoCoordinate coordinate, ZonedDateTime dateCreated, ZonedDateTime dateCoordinateUpdated, Boolean deleted,
        OnlineStatus onlineStatus, EngineType engineType, Long carId, Boolean isBooked, String licensePlate, Integer rating, Integer seatCount)
    {
        super();
        this.driverId = driverId;
        this.username = username;
        this.password = password;
        this.coordinate = coordinate;
        this.dateCreated = dateCreated;
        this.dateCoordinateUpdated = dateCoordinateUpdated;
        this.deleted = deleted;
        this.onlineStatus = onlineStatus;
        this.engineType = engineType;
        this.carId = carId;
        this.isBooked = isBooked;
        this.licensePlate = licensePlate;
        this.rating = rating;
        this.seatCount = seatCount;
    }


    public static DriverDetailDTOBuilder newBuilder()
    {
        return new DriverDetailDTOBuilder();
    }


    public Long getdriverId()
    {
        return driverId;
    }


    public Long getDriverId()
    {
        return driverId;
    }


    public String getUsername()
    {
        return username;
    }


    public String getPassword()
    {
        return password;
    }


    public GeoCoordinate getCoordinate()
    {
        return coordinate;
    }


    public ZonedDateTime getDateCreated()
    {
        return dateCreated;
    }


    public ZonedDateTime getDateCoordinateUpdated()
    {
        return dateCoordinateUpdated;
    }


    public Boolean getDeleted()
    {
        return deleted;
    }


    public OnlineStatus getOnlineStatus()
    {
        return onlineStatus;
    }


    public EngineType getEngineType()
    {
        return engineType;
    }


    public Long getCarId()
    {
        return carId;
    }


    public Boolean getIsBooked()
    {
        return isBooked;
    }


    public String getLicensePlate()
    {
        return licensePlate;
    }


    public Integer getRating()
    {
        return rating;
    }


    public Integer getSeatCount()
    {
        return seatCount;
    }

    public static class DriverDetailDTOBuilder
    {
        private Long driverId;
        private String username;
        private String password;
        private GeoCoordinate coordinate;
        private ZonedDateTime dateCreated;
        private ZonedDateTime dateCoordinateUpdated;
        private Boolean deleted;
        private OnlineStatus onlineStatus;
        private EngineType engineType;
        private Long carId;
        private Boolean isBooked;
        private String licensePlate;
        private Integer rating;
        private Integer seatCount;


        public DriverDetailDTOBuilder setDriverId(Long driverId)
        {
            this.driverId = driverId;
            return this;
        }


        public DriverDetailDTOBuilder setUsername(String username)
        {
            this.username = username;
            return this;
        }


        public DriverDetailDTOBuilder setPassword(String password)
        {
            this.password = password;
            return this;

        }


        public DriverDetailDTOBuilder setCoordinate(GeoCoordinate coordinate)
        {
            this.coordinate = coordinate;
            return this;
        }


        public DriverDetailDTOBuilder setDateCreated(ZonedDateTime dateCreated)
        {
            this.dateCreated = dateCreated;
            return this;
        }


        public DriverDetailDTOBuilder setDateCoordinateUpdated(ZonedDateTime dateCoordinateUpdated)
        {
            this.dateCoordinateUpdated = dateCoordinateUpdated;
            return this;
        }


        public DriverDetailDTOBuilder setDeleted(Boolean deleted)
        {
            this.deleted = deleted;
            return this;
        }


        public DriverDetailDTOBuilder setOnlineStatus(OnlineStatus onlineStatus)
        {
            this.onlineStatus = onlineStatus;
            return this;
        }


        public DriverDetailDTOBuilder setEngineType(EngineType engineType)
        {
            this.engineType = engineType;
            return this;
        }


        public DriverDetailDTOBuilder setCarId(Long carId)
        {
            this.carId = carId;
            return this;
        }


        public DriverDetailDTOBuilder setIsBooked(Boolean isBooked)
        {
            this.isBooked = isBooked;
            return this;
        }


        public DriverDetailDTOBuilder setLicensePlate(String licensePlate)
        {
            this.licensePlate = licensePlate;
            return this;
        }


        public DriverDetailDTOBuilder setRating(Integer rating)
        {
            this.rating = rating;
            return this;
        }


        public DriverDetailDTOBuilder setSeatCount(Integer seatCount)
        {
            this.seatCount = seatCount;
            return this;
        }


        public DriverDetailDTO createDriverDetailDTO()
        {
            return new DriverDetailDTO(
                driverId, username, password, coordinate, dateCreated, dateCoordinateUpdated, deleted, onlineStatus, engineType, carId, isBooked, licensePlate, rating, seatCount);
        }

    }
}
