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

    @PutMapping("/update")
    public void updateRepair(@RequestBody RepairResource repairDto) {
        repairService.update(repairMapper.repairResourceToRepair(repairDto));
    }

    @PostMapping("/create")
    public ResponseEntity<RepairResource> createRepair(@RequestBody RepairResource repairDto) {
        return new ResponseEntity<>(repairMapper.repairToRepairResource(
                (repairService.create(repairMapper.repairResourceToRepair(repairDto)))), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<RepairResource>> findRepairs() {
        return ResponseEntity.ok(repairMapper.repairListToRepairResourceList(repairService.findAll()));
    }

    @GetMapping(params = {"userId"})
    public ResponseEntity<List<RepairResource>> findRepairByUserId(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(repairMapper.repairListToRepairResourceList(repairService.findRepairByUserId(userId)));
    }

    @GetMapping(params = {"repairDate"})
    public ResponseEntity<List<RepairResource>> findByRepairDate(@RequestParam("repairDate")
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                            Date repairDate) {
        return ResponseEntity.ok(repairMapper.repairListToRepairResourceList(repairService.findByRepairDate(repairDate)));
    }

    @GetMapping(params = {"fromRepairDate", "toRepairDate"})
    public ResponseEntity<List<RepairResource>> findByRepairDateBetween(
            @RequestParam("fromRepairDate") Date fromRepairDate,
            @RequestParam("toRepairDate") Date toRepairDate) {
        return ResponseEntity.ok(repairMapper.repairListToRepairResourceList(repairService.findByRepairDateBetween(fromRepairDate, toRepairDate)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRepair(@PathVariable("id") Long id) {
        repairService.deleteById(id);
        return ResponseEntity.ok("Repair deleted successfully");
    }

}
