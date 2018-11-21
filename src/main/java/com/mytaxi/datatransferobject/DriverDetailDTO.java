package com.mytaxi.datatransferobject;

import java.time.ZonedDateTime;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mytaxi.domainvalue.GeoCoordinate;

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
    private String onlineStatus;

    private DriverDetailDTO()
    {}


    public DriverDetailDTO(
        Long driverId, String username, String password, GeoCoordinate coordinate, ZonedDateTime dateCreated, ZonedDateTime dateCoordinateUpdated, Boolean deleted,
        String onlineStatus)
    {
        super();
        this.driverId = driverId;
        this.username = username;
        this.password = password;
        this.coordinate = coordinate;
        this.dateCreated = dateCreated;
        this.dateCoordinateUpdated = dateCoordinateUpdated;
        this.deleted = deleted;
        this.onlineStatus=onlineStatus;
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
    
    public String getOnlineStatus()
    {
        return onlineStatus;
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
        private String onlineStatus;


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


        public DriverDetailDTOBuilder setOnlineStatus(String onlineStatus)
        {
            this.onlineStatus = onlineStatus;
            return this;
        }


        public DriverDetailDTO createDriverDetailDTO()
        {
            return new DriverDetailDTO(
                driverId, username, password, coordinate, dateCreated, dateCoordinateUpdated, deleted, onlineStatus);
        }

    }
}
