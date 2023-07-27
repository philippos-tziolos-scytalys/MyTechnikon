package com.scytalys.mytechnikon.resource;

import com.scytalys.mytechnikon.domain.PropertyType;
import com.scytalys.mytechnikon.domain.User;
import lombok.*;

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
    private User user;
}
