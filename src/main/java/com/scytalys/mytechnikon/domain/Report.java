package com.scytalys.mytechnikon.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @JsonBackReference(value = "user-report")
    @ManyToOne
    private User user;
}
