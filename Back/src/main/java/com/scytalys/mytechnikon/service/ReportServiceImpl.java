package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.Report;
import com.scytalys.mytechnikon.domain.ReportType;
import com.scytalys.mytechnikon.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportServiceImpl extends BaseServiceImpl<Report> implements ReportService {
    private final ReportRepository reportRepository;

    @Override
    public JpaRepository<Report, Long> getRepository() {
        return reportRepository;
    }

    @Override
    public List<Report> findReportsByDateRange(final Date dateFrom, final Date dateTo) {
        return reportRepository.findReportsByDateRange(dateFrom, dateTo);
    }

    @Override
    public List<Report> findReportByDate(final Date date) {
        return reportRepository.findByReportDate(date);
    }

    @Override
    public List<Report> findReportByReportType(final ReportType reportType){
        return reportRepository.findByReportType(reportType);
    }
}
