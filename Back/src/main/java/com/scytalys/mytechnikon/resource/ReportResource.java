package com.scytalys.mytechnikon.resource;

import com.scytalys.mytechnikon.domain.ReportType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportResource extends BaseResource{
    private Long id;
    private Date reportDate;
    private ReportType reportType;
    private String reportDescription;
    private UserResource user;
}
