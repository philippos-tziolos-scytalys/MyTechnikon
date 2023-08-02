package com.scytalys.mytechnikon.mapper;

import java.util.List;

public interface BaseMapper<R, D> {
    R toResource(D domain);
    List<R> toResourceList(List<D> domainList);

    D toDomain(R resource);

    List<D> toDomainList(List<R> resourceList);
}
