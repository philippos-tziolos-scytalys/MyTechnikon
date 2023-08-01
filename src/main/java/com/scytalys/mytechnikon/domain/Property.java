package com.scytalys.mytechnikon.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "Properties")
@SequenceGenerator(name = "idGenerator", sequenceName = "property_sequence", initialValue = 1, allocationSize = 1)
public class Property extends BaseModel{
    @NotNull
    @Digits(integer=9, fraction=0, message = "Invalid Property Identification Number")
    private Long pin;

    @Column(length = 50)
    @Size(max = 50, message = "Address cannot be bigger than 50 characters.")
    private String address;

    @Column(name = "year_of_construction")
    private Integer constructionYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "property_type")
    private PropertyType propertyType;

    @Column(name = "property_picture")
    private String propertyPictureUrl;

    @Column(name = "map_location_long")
    private Long propertyLongitude;

    @Column(name = "map_location_lat")
    private Long propertyLatitude;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Repair> repairs;
}
