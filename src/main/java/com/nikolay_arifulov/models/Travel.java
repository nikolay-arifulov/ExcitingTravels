package com.nikolay_arifulov.models;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "travel")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String country;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    private String header;

    private String description;

    @ManyToOne
    @JoinColumn(name = "traveller_id")
    private User traveller;
}
