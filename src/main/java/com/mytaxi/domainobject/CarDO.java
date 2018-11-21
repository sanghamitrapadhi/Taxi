package com.mytaxi.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;

import org.springframework.format.annotation.DateTimeFormat;

import com.mytaxi.domainvalue.CarType;
import com.mytaxi.domainvalue.EngineType;

@Entity
@Table(
    name = "car",
    uniqueConstraints = @UniqueConstraint(name = "uc_licensePlate", columnNames = {"licensePlate"})
)
public class CarDO
{
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarType manufacturer;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private Integer seatCount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    @Column(nullable = false)
    @org.hibernate.annotations.Type(type="yes_no")
    private Boolean convertible;
    
    @Column
    @Max(5)
    private Integer rating;
    
    @Column(nullable = false)
    @org.hibernate.annotations.Type(type="yes_no")
    private Boolean isBooked = false;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();
    
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateUpdated;

    private CarDO()
    { }
    
    public CarDO(CarType manufacturer, String licensePlate, Integer seatCount, 
        EngineType engineType, Boolean convertible)
    {
        this.manufacturer = manufacturer;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.engineType = engineType;
        this.convertible = convertible;
        this.dateUpdated=null;
    }
 
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public CarType getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(CarType manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate()
    {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    public Integer getSeatCount()
    {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount)
    {
        this.seatCount = seatCount;
    }

    public EngineType getEngineType()
    {
        return engineType;
    }

    public void setEngineType(EngineType engineType)
    {
        this.engineType = engineType;
    }

    public Boolean getConvertible()
    {
        return convertible;
    }

    public void setConvertible(Boolean convertible)
    {
        this.convertible = convertible;
    }

    
    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }


    public Boolean getIsBooked()
    {
        return isBooked;
    }

    public void setIsBooked(Boolean isBooked)
    {
        this.isBooked = isBooked;
    }

    public ZonedDateTime getDateUpdated()
    {
        return dateUpdated;
    }

    public void setDateUpdated(ZonedDateTime dateUpdated)
    {
        this.dateUpdated = dateUpdated;
    }


}
