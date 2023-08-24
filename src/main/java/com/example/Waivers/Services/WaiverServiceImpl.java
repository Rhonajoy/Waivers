package com.example.Waivers.Services;


import com.example.Waivers.Entities.Waivertype;
import com.example.Waivers.Repositories.WaivertypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WaiverServiceImpl implements WaivertypeService {


    WaivertypeRepository waivertypeRepository;

   
    public WaiverServiceImpl(WaivertypeRepository waivertypeRepository){
        this.waivertypeRepository=waivertypeRepository;
    }

    @Override
    public List<Waivertype> getWaiverTypes() {
        List<Waivertype> waivertypes = new ArrayList<>();
        waivertypeRepository.findAll().forEach(waivertypes::add);
        return waivertypes;
    }
  
    @Override
    public Waivertype getWaivertypeById(Long id) {
        return waivertypeRepository.findById(id).get();
    }

    @Override
    public Waivertype insert(Waivertype waivertype) {
        return waivertypeRepository.save(waivertype);
    }



    @Override
    public void updateWaivertype(Long id, Waivertype waivertype) {
        Waivertype waivertypeFromDb = waivertypeRepository.findById(id).get();
        System.out.println(waivertypeFromDb.toString());
        waivertypeFromDb.setName(waivertype.getName());
        waivertypeFromDb.setDescription(waivertype.getDescription());
        waivertypeFromDb.setDurationindays(waivertype.getDurationindays());
        waivertypeFromDb.setPercentage(waivertype.getPercentage());
        waivertypeRepository.save(waivertypeFromDb);
    }



}
