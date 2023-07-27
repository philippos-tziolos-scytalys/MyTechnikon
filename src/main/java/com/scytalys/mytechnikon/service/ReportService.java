package com.scytalys.mytechnikon.service;

import com.scytalys.mytechnikon.domain.Report;
import com.scytalys.mytechnikon.domain.ReportType;

import java.util.Date;
import java.util.List;

public interface ReportService extends BaseService<Report, Long> {
    List<Report> findReportsByDateRange(Date dateFrom, Date dateTo);

    List<Report> findReportByDate(Date date);

    List<Report> findReportByReportType(ReportType reportType);
}