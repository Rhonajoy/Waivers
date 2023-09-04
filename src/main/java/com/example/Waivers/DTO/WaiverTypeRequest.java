package com.example.Waivers.DTO;

import com.example.Waivers.Entities.Waivers;
import lombok.Data;

import java.util.List;

@Data

public class WaiverTypeRequest {
    private String name;

    private String description;

    private   Long durationindays;
    private Double percentage;
    private List<Waivers> waivers;
}
