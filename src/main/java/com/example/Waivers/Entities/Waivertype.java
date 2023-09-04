package com.example.Waivers.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity(name="waiver_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
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
//    @JsonIgnore
//    @JsonManagedReference
//    @OneToMany(mappedBy = "waivertype", fetch=FetchType.LAZY)
//    private List<Waivers> waivers;

}
