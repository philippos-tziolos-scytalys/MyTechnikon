package com.scytalys.mytechnikon.mapper;

import com.scytalys.mytechnikon.domain.Property;
import com.scytalys.mytechnikon.resource.PropertyResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface PropertyMapper extends BaseMapper<PropertyResource, Property> {
}
