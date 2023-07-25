package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.Property;
import com.scytalys.mytechnikon.repository.PropertyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class PropertyServiceImpl extends BaseServiceImpl<Property> implements PropertyService{
    private PropertyRepository propertyRepository;

    @Override
    public JpaRepository<Property, Long> getRepository() {
        return propertyRepository;
    }

    @Override
    public Property findByPIN(Long pin) {
        return propertyRepository.findByPin(pin);
    }

    @Override
    public List<Property> findByTIN(Long tin) {
        return propertyRepository.findByTin(tin);
    }

    @Override
    public List<Property> findByPropertyType(String propertyType) {
        return propertyRepository.findByPropertyType(propertyType);
    }

    @Override
    public List<Property> findByConstructionYearRange(int yearFrom, int yearTo) {
        return propertyRepository.findByConstructionYearRange(yearFrom, yearTo);
    }

    @Override
    public List<Property> findPropertyByUser(Long userId) {
        return propertyRepository.findPropertyByUser(userId);
    }
}
