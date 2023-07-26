package com.scytalys.mytechnikon.controller;


import com.scytalys.mytechnikon.mapper.RepairMapper;
import com.scytalys.mytechnikon.resource.RepairResource;
import com.scytalys.mytechnikon.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/repairs")
@RequiredArgsConstructor
public class RepairController {

    private final RepairService repairService;
    private final RepairMapper repairMapper;

    @PostMapping
    public ResponseEntity<RepairResource> createRepair(@RequestBody RepairResource repairResource) {
        return new ResponseEntity<>(repairMapper.toResource(
                (repairService.create(repairMapper.toDomain(repairResource)))), HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRepair(@RequestBody RepairResource repairResource) {
        repairService.update(repairMapper.toDomain(repairResource));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRepair(@PathVariable("id") Long id) {
        repairService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<RepairResource>> findRepairs() {
        return ResponseEntity.ok(repairMapper.toResourceList(repairService.findAll()));
    }

    @GetMapping(params = {"userId"})
    public ResponseEntity<List<RepairResource>> findRepairByUserId(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(repairMapper.toResourceList(repairService.findRepairByUserId(userId)));
    }

    @GetMapping(params = {"repairDate"})
    public ResponseEntity<List<RepairResource>> findByRepairDate(@RequestParam("repairDate")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                            Date repairDate) {
        return ResponseEntity.ok(repairMapper.toResourceList(repairService.findByRepairDate(repairDate)));
    }

    @GetMapping(params = {"fromRepairDate", "toRepairDate"})
    public ResponseEntity<List<RepairResource>> findByRepairDateBetween(
            @RequestParam("fromRepairDate") Date fromRepairDate,
            @RequestParam("toRepairDate") Date toRepairDate) {
        return ResponseEntity.ok(repairMapper.toResourceList(repairService.findByRepairDateBetween(fromRepairDate, toRepairDate)));
    }
}
