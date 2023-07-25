package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.Property;

import java.util.List;

public interface PropertyService extends BaseService<Property, Long> {
    Property findByPin(Long pin);

    List<Property> findByTin(Long tin);

    List<Property> findByPropertyType(String propertyType);

    List<Property> findByConstructionYearRange(int yearFrom, int yearTo);

    List<Property> findPropertyByUser(Long userId);
}
