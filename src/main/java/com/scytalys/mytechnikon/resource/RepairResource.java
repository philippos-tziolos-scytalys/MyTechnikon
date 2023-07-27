package com.scytalys.mytechnikon.resource;

import com.scytalys.mytechnikon.domain.Property;
import com.scytalys.mytechnikon.domain.RepairStatus;
import com.scytalys.mytechnikon.domain.RepairType;
import lombok.*;

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
    private Property property;
}
