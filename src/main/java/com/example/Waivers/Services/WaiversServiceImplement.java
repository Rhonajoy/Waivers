package com.example.Waivers.Services;

import com.example.Waivers.DTO.WaiverRequest;
import com.example.Waivers.Entities.Waivers;

import com.example.Waivers.Entities.Waivertype;
import com.example.Waivers.Repositories.WaiverRepository;
import com.example.Waivers.Repositories.WaivertypeRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WaiversServiceImplement implements  WaiversService{


    private final WaiverRepository waiversRepository;
    private final WaivertypeRepository waivertypeRepository;



    public WaiversServiceImplement(WaiverRepository waiversRepository, WaivertypeRepository waivertypeRepository){
        this.waiversRepository=waiversRepository;
        this.waivertypeRepository = waivertypeRepository;
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
    public void updateWaivers(Long id, Waivers waivers) {
        Waivers waiverFromDb = waiversRepository.findById(id).get();
        waiverFromDb.setLoanId(waivers.getLoanId());
        waiverFromDb.setCustomerId(waivers.getCustomerId());
        waiverFromDb.setLateFee(waivers.getLateFee());
//        waiverFromDb.setWaiverTypeId(waivers.getWaiverTypeId());
        waiversRepository.save(waiverFromDb);
    }

//    @Override
//    public List<Waivers> getWaiverbyLoanId(Long loanId) {
//
////        List<Waivers> waiversList = waiversRepository.findAll();
////
////        return waiversList.stream()
////                .filter(waivers -> waivers.getLoanId().compareTo(loanId))
////                .map(waiverFilter -> {
////                    Waivers waiver = new Waivers();
////                    BeanUtils.copyProperties(waiverFilter, waiver);
////                    return waiver;
////                })
////                .collect(Collectors.toList());
//        return null;
//    }
//    @Override
//    public Waivers findByWaiverTypeId(Long waiverTypeId){
//        return waiversRepository.findById(waiverTypeId).get();
//
//    }



//    @Override
//    public List<Waivers> getWaiverbyCustomerId(Long customerId) {
//        return null;
//    }


}
