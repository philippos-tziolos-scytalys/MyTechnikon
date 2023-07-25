package com.scytalys.mytechnikon.repository;

import com.scytalys.mytechnikon.domain.Report;
import com.scytalys.mytechnikon.domain.ReportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query("""
                select r from Report r
                where (r.reportDate >= :dateFrom and r.reportDate <= :dateTo)
            """)
    Optional<List<Report>> findReportsByRange(Date dateFrom, Date dateTo);

    Optional<List<Report>> findByReportDate(Date date);

    Optional<List<Report>> findByReportType(ReportType reportType);
}
