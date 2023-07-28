package com.scytalys.mytechnikon.resource;

import com.scytalys.mytechnikon.domain.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropertyResource extends BaseResource{
    private Long id;
    private Long pin;
    private String address;
    private Integer constructionYear;
    private PropertyType propertyType;
    private String propertyPictureUrl;
    private Long propertyLongitude;
    private Long propertyLatitude;
    private boolean active;
    private UserResource user;
}
