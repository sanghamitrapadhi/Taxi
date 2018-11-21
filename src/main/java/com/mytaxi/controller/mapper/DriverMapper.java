package com.mytaxi.controller.mapper;

import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.datatransferobject.DriverDetailDTO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainobject.VDriverDetailDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DriverMapper
{
    public static DriverDO makeDriverDO(DriverDTO driverDTO)
    {
        return new DriverDO(driverDTO.getUsername(), driverDTO.getPassword());
    }


    public static DriverDTO makeDriverDTO(DriverDO driverDO)
    {
        DriverDTO.DriverDTOBuilder driverDTOBuilder = DriverDTO.newBuilder()
            .setId(driverDO.getId())
            .setPassword(driverDO.getPassword())
            .setUsername(driverDO.getUsername());

        GeoCoordinate coordinate = driverDO.getCoordinate();
        if (coordinate != null)
        {
            driverDTOBuilder.setCoordinate(coordinate);
        }

        return driverDTOBuilder.createDriverDTO();
    }


    public static DriverDetailDTO makeDriverDetailDTO(VDriverDetailDO driverDetailDO)
    {
        DriverDetailDTO.DriverDetailDTOBuilder driverDetailDTOBuilder = DriverDetailDTO.newBuilder()
            .setDateCreated(driverDetailDO.getDateCreated())
            .setDeleted(driverDetailDO.getDeleted())
            .setDriverId(driverDetailDO.getDriverId())
            .setOnlineStatus(driverDetailDO.getOnlineStatus())
            .setUsername(driverDetailDO.getUsername())
            .setOnlineStatus(driverDetailDO.getOnlineStatus());

        if (driverDetailDO.getDateCoordinateUpdated() != null)
        {
            driverDetailDTOBuilder.setDateCoordinateUpdated(driverDetailDO.getDateCoordinateUpdated());
        }

        GeoCoordinate coordinate = driverDetailDO.getCoordinate();
        if (coordinate != null)
        {
            driverDetailDTOBuilder.setCoordinate(coordinate);
        }

        return driverDetailDTOBuilder.createDriverDetailDTO();
    }


    public static List<DriverDTO> makeDriverDTOList(Collection<DriverDO> drivers)
    {
        return drivers.stream()
            .map(DriverMapper::makeDriverDTO)
            .collect(Collectors.toList());
    }


    public static List<DriverDetailDTO> makeDriverDetailList(List<VDriverDetailDO> drivers)
    {
        return drivers.stream()
            .map(DriverMapper::makeDriverDetailDTO)
            .collect(Collectors.toList());
    }

}
