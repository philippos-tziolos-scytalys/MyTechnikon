package com.scytalys.mytechnikon.mapper;

import com.scytalys.mytechnikon.domain.Repair;
import com.scytalys.mytechnikon.resource.RepairResource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RepairMapper {
    Repair repairResourceToRepair(RepairResource repairResource);

    RepairResource repairToRepairResource(Repair repair);

    List<Repair> repairResourceListToRepairList(List<RepairResource> repairResourcetoList);

    List<RepairResource> repairListToRepairResourceList(List<Repair> repairList);
}