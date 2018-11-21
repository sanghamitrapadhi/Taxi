package com.mytaxi.dataaccessobject;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainobject.VDriverDetailDO;
import com.mytaxi.domainvalue.EngineType;
import com.mytaxi.domainvalue.OnlineStatus;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface VDriverDetailRepository extends CrudRepository<VDriverDetailDO, Long>
{

    List<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus);
    
    @Query(
        value = "SELECT * FROM V_DRIVER_DETAILS v WHERE "
            + " coalesce(v.license_plate, '%%') like :licensePlate "
            //+ "( and cast(coalesce(v.deleted, '%%') as string) like :deleted )",
            + " and cast(coalesce(v.online_status, '%%') as string) like :onlineStatus )",
          //  + "( and v.online_status like nvl(:onlineStatus,'%'))", 
        nativeQuery = true)
    List<VDriverDetailDO> findDrivers(
        @Param("licensePlate") String licensePlate,
        //@Param("deleted") String deleted
        @Param("onlineStatus") OnlineStatus onlineStatus
        //@Param("username") String username,
        //@Param("carId") Long carId,
        //@Param("onlineStatus") EngineType engineType,
        //@Param("isBooked") Boolean isBooked,
        //@Param("rating") Integer rating,  
        //@Param("seatCount") Integer seatCount,
        //@Param("driverId") Long driverId
        );
}
