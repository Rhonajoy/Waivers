package com.example.Waivers.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity(name="waiver_type")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Waivertype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private   Long durationindays;
    @Column(nullable = false)
    private Double percentage;
    @OneToMany(mappedBy = "waivertype", fetch=FetchType.LAZY)
    private List<Waivers> waivers;

}
