package com.scytalys.mytechnikon.controller;

import com.scytalys.mytechnikon.domain.Report;
import com.scytalys.mytechnikon.domain.ReportType;
import com.scytalys.mytechnikon.mapper.PropertyMapper;
import com.scytalys.mytechnikon.resource.PropertyResource;
import com.scytalys.mytechnikon.service.PropertyService;
import com.scytalys.mytechnikon.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;
    private final PropertyMapper propertyMapper;
    private final ReportService reportService;

    private void createPropertyEmbeddedReport(PropertyResource propertyResource, ReportType reportType, String description){
        Report report = new Report();
        report.setReportDate(Date.from(Instant.now()));
        report.setReportType(reportType);
        report.setReportDescription(description);
        reportService.create(report);
    }

    @PostMapping
    public ResponseEntity<PropertyResource> createProperty(@RequestBody PropertyResource propertyResource) {
        Report report = new Report();
        report.setReportDate(Date.from(Instant.now()));
        report.setReportType(ReportType.PROPERTY_REGISTRATION);
        report.setReportDescription("PIN: " + propertyMapper.toDomain(propertyResource).getPin());
        report.setUser(propertyMapper.toDomain(propertyResource).getUser());
        reportService.create(report);
        return new ResponseEntity<>(propertyMapper.toResource(
                propertyService.create(propertyMapper.toDomain(propertyResource))), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProperty(@RequestBody PropertyResource propertyResource) {
        String description = "PIN: " + propertyMapper.toDomain(propertyResource).getPin();
        createPropertyEmbeddedReport(propertyResource, ReportType.PROPERTY_UPDATE, description);
        propertyService.update(propertyMapper.toDomain(propertyResource));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProperty(@PathVariable("id") Long propertyId) {
        PropertyResource propertyResource = propertyMapper.toResource(propertyService.get(propertyId));
        String description = "PIN: " + propertyResource.getPin();
        createPropertyEmbeddedReport(propertyResource, ReportType.PROPERTY_DELETION, description);
        propertyService.deleteById(propertyId);
    }

    @GetMapping
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

    @GetMapping("/{propertyId}")
    public ResponseEntity <PropertyResource> findPropertyById(@PathVariable("propertyId") Long propertyId) {
        return ResponseEntity.ok(propertyMapper.toResource(propertyService.get(propertyId)));
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
}
