package com.mytaxi.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.springframework.format.annotation.DateTimeFormat;

import com.mytaxi.domainvalue.GeoCoordinate;

@Entity
@Table(name = "V_DRIVER_DETAILS")
@Immutable
@Subselect("select * from V_DRIVER_DETAILS R")
public class VDriverDetailDO
{

    @Id
    private Long driverId;

    @Column
    private String username;

    @Column
    private String password;
    
    @Column
    private GeoCoordinate coordinate;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated;

    @Column
    private ZonedDateTime dateCoordinateUpdated;

    @Column
    private Boolean deleted;

    @Column
    private String onlineStatus;
    
    @Column
    private String engineType;

    @Column
    private Boolean isBooked;
    
    @Column
    private Long carId;
    
    @Column
    private String licensePlate;
    
    @Column
    private Integer rating;

    @Column
    private Integer seatCount;
    
    private VDriverDetailDO()
    {
    }

    public Long getDriverId()
    {
        return driverId;
    }

    public void setDriverId(Long driverId)
    {
        this.driverId = driverId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public GeoCoordinate getCoordinate()
    {
        return coordinate;
    }

    public void setCoordinate(GeoCoordinate coordinate)
    {
        this.coordinate = coordinate;
    }

    public ZonedDateTime getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public ZonedDateTime getDateCoordinateUpdated()
    {
        return dateCoordinateUpdated;
    }

    public void setDateCoordinateUpdated(ZonedDateTime dateCoordinateUpdated)
    {
        this.dateCoordinateUpdated = dateCoordinateUpdated;
    }

    public Boolean getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    public String getOnlineStatus()
    {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus)
    {
        this.onlineStatus = onlineStatus;
    }

    public String getEngineType()
    {
        return engineType;
    }

    public void setEngineType(String engineType)
    {
        this.engineType = engineType;
    }

    public Boolean getIsBooked()
    {
        return isBooked;
    }

    public void setIsBooked(Boolean isBooked)
    {
        this.isBooked = isBooked;
    }

    public Long getCarId()
    {
        return carId;
    }

    public void setCarId(Long carId)
    {
        this.carId = carId;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }

    public Integer getSeatCount()
    {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount)
    {
        this.seatCount = seatCount;
    }

}
