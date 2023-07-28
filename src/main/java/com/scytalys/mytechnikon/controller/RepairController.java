package com.scytalys.mytechnikon.controller;


import com.scytalys.mytechnikon.domain.Report;
import com.scytalys.mytechnikon.domain.ReportType;
import com.scytalys.mytechnikon.mapper.RepairMapper;
import com.scytalys.mytechnikon.resource.RepairResource;
import com.scytalys.mytechnikon.service.RepairService;
import com.scytalys.mytechnikon.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/repairs")
@RequiredArgsConstructor
public class RepairController {

    private final RepairService repairService;
    private final RepairMapper repairMapper;
    private final ReportService reportService;

    private void createRepairEmbeddedReport(RepairResource repairResource, ReportType reportType, String description){
        Report report = new Report();
        report.setReportDate(Date.from(Instant.now()));
        report.setReportType(reportType);
        report.setReportDescription(description);
        report.setUser(repairMapper.toDomain(repairResource).getProperty().getUser());
        reportService.create(report);
    }

    @PostMapping
    public ResponseEntity<RepairResource> createRepair(@RequestBody RepairResource repairResource) {
        Report report = new Report();
        report.setReportDate(Date.from(Instant.now()));
        report.setReportType(ReportType.REPAIR_REGISTRATION);
        report.setReportDescription("TYPE: " + repairMapper.toDomain(repairResource).getRepairType() +
                                    "DATE" + repairMapper.toDomain(repairResource).getRepairDate());
        reportService.create(report);
        return new ResponseEntity<>(repairMapper.toResource(
                (repairService.create(repairMapper.toDomain(repairResource)))), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRepair(@RequestBody RepairResource repairResource) {
        String description = "ID: " + repairMapper.toDomain(repairResource).getId();
        createRepairEmbeddedReport(repairResource, ReportType.REPAIR_UPDATE, description);
        repairService.update(repairMapper.toDomain(repairResource));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRepair(@PathVariable("id") Long id) {
        RepairResource repairResource = repairMapper.toResource(repairService.get(id));
        String description = "ID: " + repairMapper.toDomain(repairResource).getId();
        createRepairEmbeddedReport(repairResource, ReportType.REPAIR_DELETION, description);
        repairService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<RepairResource>> findRepairs() {
        return ResponseEntity.ok(repairMapper.toResourceList(repairService.findAll()));
    }

    @GetMapping("/{repairId}")
    public ResponseEntity<RepairResource> findRepairById(@PathVariable("repairId") Long repairId) {
        return ResponseEntity.ok(repairMapper.toResource(repairService.get(repairId)));
    }

    @GetMapping(params = {"userId"})
    public ResponseEntity<List<RepairResource>> findRepairRepairByUserId(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(repairMapper.toResourceList(repairService.findRepairByUserId(userId)));
    }

    @GetMapping(params = {"repairDate"})
    public ResponseEntity<List<RepairResource>> findRepairByRepairDate(@RequestParam("repairDate")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                            Date repairDate) {
        return ResponseEntity.ok(repairMapper.toResourceList(repairService.findByRepairDate(repairDate)));
    }

    @GetMapping(params = {"fromRepairDate", "toRepairDate"})
    public ResponseEntity<List<RepairResource>> findRepairByRepairDateBetween(
            @RequestParam("fromRepairDate") Date fromRepairDate,
            @RequestParam("toRepairDate") Date toRepairDate) {
        return ResponseEntity.ok(repairMapper.toResourceList(repairService.findByRepairDateBetween(fromRepairDate, toRepairDate)));
    }
}
