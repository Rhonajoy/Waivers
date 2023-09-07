package com.example.Waivers.Services;

import com.example.Waivers.DTO.WaiverRequest;
import com.example.Waivers.Entities.Waivers;

import com.example.Waivers.Entities.Waivertype;
import com.example.Waivers.Repositories.WaiverRepository;
import com.example.Waivers.Repositories.WaivertypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WaiversServiceImplement implements  WaiversService{

  @Autowired
    private  WaiverRepository waiversRepository;
  @Autowired
  private WaivertypeRepository waivertypeRepository;



    @Override
    public List<Waivers> getallWaivers() {
        List<Waivers> waivers = new ArrayList<>();
        waiversRepository.findAll().forEach(waivers::add);
        return waivers;
    }

    @Override
    public Waivers getWaiverById(Long id) {
        return waiversRepository.findById(id).get();

    }

    @Override
    public Waivers insert(WaiverRequest waiverrequest) {
        Waivers waiver= new Waivers();
        waiver.setLateFee(waiverrequest.getLateFee());
        waiver.setCustomerId(waiverrequest.getCustomerId());
        waiver.setLoanId(waiverrequest.getLoanId());
        Optional<Waivertype> waiverType=waivertypeRepository.findById(waiverrequest.getWaiverTypeId());
        if (waiverType.isPresent()) {
            waiver.setWaivertype(waiverType.get());
        }

        return waiversRepository.save(waiver);


    }



    @Override
    public Waivers updateWaivers(Long id, Waivers waivers) {
        Waivers waiverFromDb = waiversRepository.findById(id).get();
        waiverFromDb.setLoanId(waivers.getLoanId());
        waiverFromDb.setCustomerId(waivers.getCustomerId());
        waiverFromDb.setLateFee(waivers.getLateFee());
       return  waiversRepository.save(waiverFromDb);
    }




}
