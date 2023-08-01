package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.Repair;
import com.scytalys.mytechnikon.domain.RepairStatus;
import com.scytalys.mytechnikon.domain.RepairType;

import java.util.Date;
import java.util.List;

public interface RepairService extends BaseService<Repair, Long> {
    Repair findByRepairDateAndRepairTypeAndPropertyId(Date repairDate, RepairType repairType, Long propertyId);
    List<Repair> findRepairByUserId(Long userId);

    List<Repair> findByRepairDate(Date repairDate);

    List<Repair> findByRepairDateBetween(Date fromRepairDate, Date toRepairDate);

    List<Repair> findByRepairStatus(RepairStatus repairStatus);
}
