package com.mytaxi.dataaccessobject;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mytaxi.domainobject.VDriverDetailDO;

/**
 * Database Access Object for driver detail view.
 * <p/>
 */
public interface VDriverDetailRepository extends CrudRepository<VDriverDetailDO, Long>
{

    @Query(value = "SELECT * FROM V_DRIVER_DETAILS v WHERE "
        + " coalesce(v.license_plate, '%%') like :licensePlate "
        + " and to_char(v.deleted) like :deleted "
        + " and v.online_status like :onlineStatus "
        + " and coalesce(v.username, '%%') like :username "
        + " and coalesce(to_char(v.car_id), '%%') like :carId "
        + " and coalesce(v.engine_type, '%%') like :engineType "
        + " and coalesce(to_char(v.is_booked), '%%') like :isBooked "
        + " and coalesce(to_char(v.rating), '%%') like :rating "
        + " and coalesce(to_char(v.seat_count), '%%') like :seatCount ", nativeQuery = true)

    List<VDriverDetailDO> findDrivers(
        @Param("licensePlate") String licensePlate,
        @Param("deleted") String deleted,
        @Param("onlineStatus") String onlineStatus,
        @Param("username") String username,
        @Param("carId") String carId,
        @Param("engineType") String engineType,
        @Param("isBooked") String isBooked,
        @Param("rating") String rating,
        @Param("seatCount") String seatCount);
}
