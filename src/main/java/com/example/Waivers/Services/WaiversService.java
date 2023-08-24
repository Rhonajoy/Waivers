package com.example.Waivers.Services;

import com.example.Waivers.Entities.Waivers;


import java.util.List;

public interface WaiversService {
    List<Waivers> getallWaivers();
    Waivers getWaiverById(Long id);
    Waivers insert(Waivers waivers);
    void updateWaivers(Long id, Waivers waivers);
    List<Waivers> getWaiverbyLoanId(Long loanId);
    List<Waivers> getWaiverbyCustomerId(Long customerId);


}
