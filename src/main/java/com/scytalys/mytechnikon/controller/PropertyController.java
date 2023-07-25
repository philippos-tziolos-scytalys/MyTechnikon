package com.scytalys.mytechnikon.controller;

import com.scytalys.mytechnikon.domain.Property;
import com.scytalys.mytechnikon.mapper.PropertyMapper;
import com.scytalys.mytechnikon.resource.PropertyResource;
import com.scytalys.mytechnikon.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;

    private final PropertyMapper propertyMapper;

    @PostMapping("/create")
    public ResponseEntity<PropertyResource> createProperty(@RequestBody PropertyResource propertyResource) {
        return new ResponseEntity<>(propertyMapper.toResource(
                propertyService.create(propertyMapper.toDomain(propertyResource))), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Property>> findProperties() {
        return ResponseEntity.ok(propertyService.findAll());
    }

    @PutMapping("/update")
    public void updateProperty(@RequestBody PropertyResource propertyResource) {
        propertyService.update(propertyMapper.toDomain(propertyResource));
    }

    @GetMapping(params = {"pin"})
    public ResponseEntity<Property> findPropertyByPin(@RequestParam("pin") Long pin) {
        return ResponseEntity.ok(propertyService.findByPin(pin));
    }

    @GetMapping(params = {"tin"})
    public ResponseEntity<List<Property>> findPropertyByTin(@RequestParam("tin") Long tin) {
        return ResponseEntity.ok(propertyService.findByTin(tin));
    }

    @GetMapping(params = {"propertyType"})
    public ResponseEntity<List<Property>> findPropertyByPropertyType(@RequestParam("propertyType") String propertyType) {
        return ResponseEntity.ok(propertyService.findByPropertyType(propertyType));
    }

    @GetMapping(params = {"yearFrom", "yearTo"})
    public ResponseEntity<List<Property>> findPropertyByConstructionYearRange(@RequestParam("yearFrom") int yearFrom,
                                                                              @RequestParam("yearTo") int yearTo) {
        return ResponseEntity.ok(propertyService.findByConstructionYearRange(yearFrom, yearTo));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable("id") Long propertyId) {
        propertyService.deleteById(propertyId);
        return ResponseEntity.ok("Repair deleted successfully");
    }

    @GetMapping(headers = "action=findPropertyByUser")
    public ResponseEntity<List<PropertyResource>> findPropertyByUser(Long userId) {
        return ResponseEntity.ok(propertyMapper.toResourceList(propertyService.findPropertyByUser(userId)));
    }
}
