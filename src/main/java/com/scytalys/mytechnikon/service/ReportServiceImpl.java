package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.Report;
import com.scytalys.mytechnikon.domain.ReportType;
import com.scytalys.mytechnikon.repository.ReportRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public class ReportServiceImpl extends BaseServiceImpl<Report> implements ReportService {
    private ReportRepository reportRepository;

    @Override
    public JpaRepository<Report, Long> getRepository() {
        return reportRepository;
    }

    @Override
    public List<Report> findReportsByDateRange(final Date dateFrom, final Date dateTo) {
        return reportRepository.findReportsByDateRange(dateFrom, dateTo);
    }

    @Override
    public List<Report> findByReportDate(final Date date) {
        return reportRepository.findByReportDate(date);
    }

    @Override
    public List<Report> findByReportType(final ReportType reportType){
        return reportRepository.findByReportType(reportType);
    }
}
