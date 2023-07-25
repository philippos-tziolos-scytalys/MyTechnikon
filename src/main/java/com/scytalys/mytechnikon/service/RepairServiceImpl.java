package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.Repair;
import com.scytalys.mytechnikon.domain.RepairStatus;
import com.scytalys.mytechnikon.repository.RepairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RepairServiceImpl extends BaseServiceImpl<Repair> implements RepairService {
    private final RepairRepository repairRepository;

    @Override
    public JpaRepository<Repair, Long> getRepository() {
        return repairRepository;
    }

    @Override
    public List<Repair> findRepairByUserId(final Long userId) {
        return repairRepository.findRepairByUserId(userId);
    }

    @Override
    public List<Repair> findByRepairDate(final Date repairDate) {
        return repairRepository.findByRepairDate(repairDate);
    }

    @Override
    public List<Repair> findByRepairDateBetween(final Date fromRepairDate, final Date toRepairDate) {
        return repairRepository.findByRepairDateBetween(fromRepairDate, toRepairDate);
    }

    @Override
    public List<Repair> findByRepairStatus(final RepairStatus repairStatus) {
        return repairRepository.findByRepairStatus(repairStatus);
    }
}
