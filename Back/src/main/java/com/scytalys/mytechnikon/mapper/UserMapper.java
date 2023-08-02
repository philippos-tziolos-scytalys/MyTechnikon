package com.scytalys.mytechnikon.mapper;

import com.scytalys.mytechnikon.domain.User;
import com.scytalys.mytechnikon.resource.UserResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface UserMapper extends BaseMapper<UserResource, User>{
}
