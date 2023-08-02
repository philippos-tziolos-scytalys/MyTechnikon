package com.scytalys.mytechnikon.mapper;

import com.scytalys.mytechnikon.domain.Report;
import com.scytalys.mytechnikon.resource.ReportResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface ReportMapper extends BaseMapper<ReportResource, Report> {
}
