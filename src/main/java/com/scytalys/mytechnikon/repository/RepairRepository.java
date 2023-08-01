package com.scytalys.mytechnikon.repository;

import com.scytalys.mytechnikon.domain.Repair;
import com.scytalys.mytechnikon.domain.RepairStatus;
import com.scytalys.mytechnikon.domain.RepairType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {
    @Query("""
            select r from Repair r
            where r.repairDate = :repairDate and r.repairType = :repairType and r.property.id = :propertyId
            """)
    Repair findByRepairDateAndRepairTypeAndPropertyId(Date repairDate, RepairType repairType, Long propertyId);
    @Query("""
            select r from Repair r
            join r.property p
            join p.user u
            where u.id = :userId
            order by r.repairDate
            """)
    List<Repair> findByUserId(Long userId);

    List<Repair> findByRepairDate(Date repairDate);

    List<Repair> findByRepairDateBetween(Date fromRepairDate, Date toRepairDate);

    List<Repair> findByRepairStatus(RepairStatus repairStatus);
}
