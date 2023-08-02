package com.scytalys.mytechnikon.mapper;

import com.scytalys.mytechnikon.domain.Repair;
import com.scytalys.mytechnikon.resource.RepairResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface RepairMapper extends BaseMapper<RepairResource, Repair> {
}