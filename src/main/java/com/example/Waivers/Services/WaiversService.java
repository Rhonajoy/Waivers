package com.example.Waivers.Services;

import com.example.Waivers.DTO.WaiverRequest;
import com.example.Waivers.Entities.Waivers;
import org.springframework.stereotype.Service;


import java.util.List;
@Service

public interface WaiversService {

    List<Waivers> getallWaivers();
    Waivers getWaiverById(Long id);
    Waivers insert(WaiverRequest waiver);
    Waivers updateWaivers(Long id, Waivers waivers);



}
