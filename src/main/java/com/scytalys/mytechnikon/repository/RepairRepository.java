package com.scytalys.mytechnikon.repository;

import com.scytalys.mytechnikon.domain.Repair;
import com.scytalys.mytechnikon.domain.RepairStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RepairRepository extends JpaRepository<Repair, Long> {
    @Query("""
            select r from Repair r
            join r.property p
            join p.user u
            where u.id = :userId
            order by r.repairDate
            """)
    Optional<List<Repair>> findRepairByUserId(Long userId);

    Optional<List<Repair>> findByRepairDate(Date repairDate);

    Optional<List<Repair>> findByRepairDateBetween(Date fromRepairDate, Date toRepairDate);

    Optional<List<Repair>> findByRepairStatus(RepairStatus repairStatus);
}
