package com.scytalys.mytechnikon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Users")
@SequenceGenerator(name = "idGenerator", sequenceName = "user_sequence", initialValue = 1, allocationSize = 1)
public class User extends BaseModel{
    @NotNull
    @Digits(integer=9, fraction=0, message = "TIN number must be exactly 9 digits")
    private Long tin;

    @Column(name = "first_name", length = 50)
    private String name;

    @Column(name = "last_name", length = 50)
    private String surname;

    @Column(length = 50)
    @Size(max = 50, message = "Address cannot be bigger than 50 characters.")
    private String address;

    @NotNull
    @Digits(integer=12, fraction=0, message = "Phone number must be exactly 10 digits")
    private Long phone;

    @NotNull
    @Column(unique = true)
    private String username;

    @Email
    @Column(length = 50)
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$", message = "Invalid password")
    private String password;

    @Column(name = "user_picture")
    private String userPictureUrl;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Property> properties;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Report> reports;
}
