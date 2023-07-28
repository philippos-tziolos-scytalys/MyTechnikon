package com.scytalys.mytechnikon.resource;

import com.scytalys.mytechnikon.domain.RepairStatus;
import com.scytalys.mytechnikon.domain.RepairType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RepairResource extends BaseResource {
    private Long id;
    private RepairType repairType;
    private RepairStatus repairStatus;
    private String description;
    private Date repairDate;
    private BigDecimal cost;
    private PropertyResource property;
}
