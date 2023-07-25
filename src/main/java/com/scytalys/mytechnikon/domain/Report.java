package com.scytalys.mytechnikon.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Reports")
@SequenceGenerator(name = "idGenerator", sequenceName = "report_sequence", initialValue = 1, allocationSize = 1)
public class Report extends BaseModel {

    @Column(name = "date")
    private Date reportDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "type of report")
    private ReportType reportType;

    @Column(name = "description")
    private String reportDescription;

    @ManyToOne
    private User user;
}
