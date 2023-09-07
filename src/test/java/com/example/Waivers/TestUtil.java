package com.example.Waivers;

import com.example.Waivers.DTO.WaiverRequest;
import com.example.Waivers.DTO.WaiverTypeRequest;
import com.example.Waivers.Entities.Waivers;
import com.example.Waivers.Entities.Waivertype;

public class TestUtil {
    public static WaiverRequest createWaiverRequest() {
        WaiverRequest waiverRequest = new WaiverRequest();
        waiverRequest.setWaiverTypeId(1L);
        waiverRequest.setCustomerId(1L);
        waiverRequest.setLateFee(10L);
        waiverRequest.setLoanId(1L);
        return waiverRequest;
    }

    public static Waivers createWaiver() {
        Waivertype waiverType = new Waivertype();
        waiverType.setName("Test Waiver");
        waiverType.setDescription("Testing");
        waiverType.setDurationindays(10L);
        waiverType.setPercentage(0.05);

        Waivers waivers = new Waivers();
        waivers.setId(1L);
        waivers.setLoanId(123L);
        waivers.setCustomerId(456L);
        waivers.setLateFee(500L);
        waivers.setWaivertype(waiverType);

        return waivers;
    }
    public static Waivertype createWaiverType() {

        Waivertype waiverType = new Waivertype();
        waiverType.setName("Test Waiver");
        waiverType.setDescription("Testing");
        waiverType.setDurationindays(10L);
        waiverType.setPercentage(0.05);
        return waiverType;
    }
    public static WaiverTypeRequest createWaivertypeRequest(){
        WaiverTypeRequest waiverTypeRequest=new WaiverTypeRequest();
        waiverTypeRequest.setName("Christmas Waiver");
        waiverTypeRequest.setDescription("A christmas waiver");
        waiverTypeRequest.setDurationindays(10L);
        waiverTypeRequest.setPercentage(0.05);
        return  waiverTypeRequest;
    }
}