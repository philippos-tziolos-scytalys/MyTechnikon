package com.scytalys.mytechnikon.resource;

import com.scytalys.mytechnikon.domain.Property;
import com.scytalys.mytechnikon.domain.Role;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResource extends BaseResource{
    private Long id;
    private Long tin;
    private String name;
    private String surname;
    private String address;
    private Long phone;
    private String username;
    private String email;
    private String password;
    private String userPictureUrl;
    private Role role;
    private List<Property> properties;
}
