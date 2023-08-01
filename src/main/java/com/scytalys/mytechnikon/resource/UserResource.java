package com.scytalys.mytechnikon.resource;

import com.scytalys.mytechnikon.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
