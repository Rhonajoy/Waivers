package com.example.Waivers.Services;

import com.example.Waivers.Entities.Waivers;

import com.example.Waivers.Repositories.WaiverRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class WaiversServiceImplement implements  WaiversService{


    WaiverRepository waiversRepository;



    public WaiversServiceImplement(WaiverRepository waiversRepository){
        this.waiversRepository=waiversRepository;
    }

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
    public Waivers insert(Waivers waivers) {
        return waiversRepository.save(waivers);

    }



    @Override
    public void updateWaivers(Long id, Waivers waivers) {
        Waivers waiverFromDb = waiversRepository.findById(id).get();
        waiverFromDb.setLoanId(waivers.getLoanId());
        waiverFromDb.setCustomerId(waivers.getCustomerId());
        waiverFromDb.setLateFee(waivers.getLateFee());
//        waiverFromDb.setWaiverTypeId(waivers.getWaiverTypeId());
        waiversRepository.save(waiverFromDb);
    }

    @Override
    public List<Waivers> getWaiverbyLoanId(Long loanId) {

//        List<Waivers> waiversList = waiversRepository.findAll();
//
//        return waiversList.stream()
//                .filter(waivers -> waivers.getLoanId().compareTo(loanId))
//                .map(waiverFilter -> {
//                    Waivers waiver = new Waivers();
//                    BeanUtils.copyProperties(waiverFilter, waiver);
//                    return waiver;
//                })
//                .collect(Collectors.toList());
        return null;
    }



    @Override
    public List<Waivers> getWaiverbyCustomerId(Long customerId) {
        return null;
    }


}
