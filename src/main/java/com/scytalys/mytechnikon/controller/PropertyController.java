package com.scytalys.mytechnikon.controller;

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

    @PutMapping("/update")
    public void updateProperty(@RequestBody PropertyResource propertyResource) {
        propertyService.update(propertyMapper.toDomain(propertyResource));
    }

    @GetMapping()
    public ResponseEntity<List<PropertyResource>> findProperties() {
        return ResponseEntity.ok(propertyMapper.toResourceList(propertyService.findAll()));
    }

    @GetMapping(params = {"pin"})
    public ResponseEntity<PropertyResource> findPropertyByPin(@RequestParam("pin") Long pin) {
        return ResponseEntity.ok(propertyMapper.toResource(propertyService.findByPin(pin)));
    }

    @GetMapping(params = {"tin"})
    public ResponseEntity<List<PropertyResource>> findPropertyByTin(@RequestParam("tin") Long tin) {
        return ResponseEntity.ok(propertyMapper.toResourceList(propertyService.findByTin(tin)));
    }

    @GetMapping(params = {"property_id"})
    public ResponseEntity <PropertyResource> findPropertyById(@RequestParam("property_id") Long property_id) {
        return ResponseEntity.ok(propertyMapper.toResource(propertyService.get(property_id)));
    }

    @GetMapping(params = {"userId"})
    public ResponseEntity<List<PropertyResource>> findPropertyByUserId(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(propertyMapper.toResourceList(propertyService.findPropertyByUserId(userId)));
    }

    @GetMapping(params = {"propertyType"})
    public ResponseEntity<List<PropertyResource>> findPropertyByPropertyType(@RequestParam("propertyType") String propertyType) {
        return ResponseEntity.ok(propertyMapper.toResourceList(propertyService.findByPropertyType(propertyType)));
    }

    @GetMapping(params = {"yearFrom", "yearTo"})
    public ResponseEntity<List<PropertyResource>> findPropertyByConstructionYearRange(@RequestParam("yearFrom") int yearFrom,
                                                                              @RequestParam("yearTo") int yearTo) {
        return ResponseEntity.ok(propertyMapper.toResourceList(propertyService.findByConstructionYearRange(yearFrom, yearTo)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable("id") Long propertyId) {
        propertyService.deleteById(propertyId);
        return ResponseEntity.ok("Repair deleted successfully");
    }
}
