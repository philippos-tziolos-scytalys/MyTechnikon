package com.scytalys.mytechnikon.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Repairs")
@SequenceGenerator(name = "idGenerator", sequenceName = "repair_seq", initialValue = 1, allocationSize = 1)
public class Repair extends BaseModel {
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private RepairType repairType;

    @Enumerated(EnumType.STRING)
    @Column(length = 11, nullable = false)
    private RepairStatus repairStatus = RepairStatus.PENDING;

    @NotNull
    @Column(length = 5000, nullable = false)
    private String description;

    @NotNull
    @Column(nullable = false)
    private Date repairDate;

    @NotNull
    @Column(nullable = false)
    private BigDecimal cost;

    @JsonBackReference(value = "property-repair")
    @ManyToOne
    private Property property;
}
