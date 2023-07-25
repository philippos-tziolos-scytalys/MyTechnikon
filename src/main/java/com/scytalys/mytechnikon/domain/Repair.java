package com.scytalys.mytechnikon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Repairs")
@SequenceGenerator(name = "idGenerator", sequenceName = "repair_seq", initialValue = 1, allocationSize = 1)
public class Repair extends BaseModel {


    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private RepairType repairType;

    @Enumerated(EnumType.STRING)
    @Column(length = 11, nullable = false)
    private RepairStatus repairStatus = RepairStatus.PENDING;

    @NotEmpty
    @Column(length = 5000, nullable = false)
    private String description;

    @NotEmpty
    @Column(nullable = false)
    private Date repairDate;

    @NotEmpty
    @Column(nullable = false)
    private BigDecimal cost;

    @ManyToOne
    private Property property;
}
