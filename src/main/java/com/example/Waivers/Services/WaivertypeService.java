package com.example.Waivers.Services;

import com.example.Waivers.Entities.Waivertype;

import java.util.List;

public interface WaivertypeService {
    List<Waivertype> getWaiverTypes();
    Waivertype getWaivertypeById(Long id);
    Waivertype insert(Waivertype waivertype);
    void updateWaivertype(Long id, Waivertype waivertype);




}
