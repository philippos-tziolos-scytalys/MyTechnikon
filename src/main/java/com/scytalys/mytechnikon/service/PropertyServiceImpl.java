package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.Property;
import com.scytalys.mytechnikon.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PropertyServiceImpl extends BaseServiceImpl<Property> implements PropertyService{
    private final PropertyRepository propertyRepository;

    @Override
    public JpaRepository<Property, Long> getRepository() {
        return propertyRepository;
    }

    @Override
    public Property findByPin(Long pin) {
        return propertyRepository.findByPin(pin);
    }

    @Override
    public List<Property> findByTin(Long tin) {
        return propertyRepository.findByTin(tin);
    }

    @Override
    public List<Property> findByPropertyType(String propertyType) {
        return propertyRepository.findByPropertyType(propertyType);
    }

    @Override
    public List<Property> findByConstructionYearRange(int yearFrom, int yearTo) {
        return propertyRepository.findByConstructionYearBetween(yearFrom, yearTo);
    }

    @Override
    public List<Property> findPropertyByUserId(Long userId) {
        return propertyRepository.findPropertyByUser(userId);
    }
}
