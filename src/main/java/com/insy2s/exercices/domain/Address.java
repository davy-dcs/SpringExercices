package com.insy2s.exercices.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String streetNumber;

    private String streetName;

    private String zipCode;

    private String city;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<User> users = new ArrayList<>();
}
