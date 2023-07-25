package com.scytalys.mytechnikon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Users")
@SequenceGenerator(name = "idGenerator", sequenceName = "user_sequence", initialValue = 1, allocationSize = 1)
public class User extends BaseModel{
    @NotEmpty
    @Size(max=9, min=9, message = "TIN number must be exactly 9 digits")
    private Long tin;

    @Column(name = "first_name", length = 50)
    private String name;

    @Column(name = "last_name", length = 50)
    private String surname;

    @Column(length = 50)
    @Size(max = 50, message = "Address cannot be bigger than 50 characters.")
    private String address;

    @NotEmpty
    @Size(max=10, min=10, message = "Phone number must be exactly 10 digits")
    private Long phone;

    @NotEmpty
    @Column(unique = true)
    private String username;

    @Email
    @Column(length = 50)
    private String email;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$", message = "Invalid password")
    private String password;

    @NotEmpty
    private Role role;

    @Column(name = "user_picture")
    private String userPictureUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Property> properties;
}
