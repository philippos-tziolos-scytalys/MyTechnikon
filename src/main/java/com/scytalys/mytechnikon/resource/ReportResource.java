package com.scytalys.mytechnikon.resource;

import com.scytalys.mytechnikon.domain.ReportType;
import com.scytalys.mytechnikon.domain.User;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReportResource extends BaseResource{
    private Long id;
    private Date reportDate;
    private ReportType reportType;
    private String reportDescription;
    private User user;
}
