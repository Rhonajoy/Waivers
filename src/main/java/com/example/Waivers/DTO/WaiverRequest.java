package com.example.Waivers.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WaiverRequest {
    private Long loanId;
    private Long customerId;
    private Long lateFee;

    private Long waiverTypeId;
}
