package com.scytalys.mytechnikon.controller;

import com.scytalys.mytechnikon.domain.ReportType;
import com.scytalys.mytechnikon.mapper.ReportMapper;
import com.scytalys.mytechnikon.resource.ReportResource;
import com.scytalys.mytechnikon.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final ReportMapper reportMapper;

    @PostMapping
    public ResponseEntity<ReportResource> createReport(@RequestBody ReportResource reportResource) {

        return new ResponseEntity<>(reportMapper.toResource(
                reportService.create(reportMapper.toDomain(reportResource))), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReport(@RequestBody ReportResource reportResource) {
        reportService.update(reportMapper.toDomain(reportResource));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReport(@PathVariable("id") final Long id) {
        reportService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<ReportResource>> findReports() {
        return ResponseEntity.ok(reportMapper.toResourceList(reportService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportResource> findReportById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(reportMapper.toResource(reportService.get(id)));
    }

    @GetMapping(params = {"date"})
    public ResponseEntity<List<ReportResource>> findReportByDate(@RequestParam("date") Date date) {
        return ResponseEntity.ok(reportMapper.toResourceList(reportService.findReportByDate(date)));
    }

    @GetMapping(params = {"reportType"})
    public ResponseEntity<List<ReportResource>> findReportByDate(@RequestParam("reportType") ReportType reportType) {
        return ResponseEntity.ok(reportMapper.toResourceList(reportService.findReportByReportType(reportType)));
    }

    @GetMapping(params = {"fromDate", "toDate"})
    public ResponseEntity<List<ReportResource>> findReportByDateBetween(
            @RequestParam("fromDate") Date fromDate,
            @RequestParam("toDate") Date toDate) {
        return ResponseEntity.ok(reportMapper.toResourceList(reportService.findReportsByDateRange(fromDate, toDate)));
    }
}
