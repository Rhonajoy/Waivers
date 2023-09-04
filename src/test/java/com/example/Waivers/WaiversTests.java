package com.example.Waivers;

import com.example.Waivers.Controllers.WaiversController;
import com.example.Waivers.Entities.Waivers;
import com.example.Waivers.Entities.Waivertype;
import com.example.Waivers.Repositories.WaiverRepository;
import com.example.Waivers.Repositories.WaivertypeRepository;
import com.example.Waivers.Services.WaiversService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WaiversController.class)
//@SpringBootTest
@ComponentScan(basePackages = "com.example.Waivers.Repositories.WaivertypeRepository")
//@ComponentScan(basePackages = {"com.example.Waivers.Services.",""})

public class WaiversTests {
    private static final String END_POINT_PATH = "/api/waivers";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private WaiversService service;
    @MockBean
    private WaivertypeRepository waivertypeRepository;
//    private  WaivertypeRepository waivertypeRepository;



//    public WaiversTests(WaivertypeRepository waivertypeRepository){
//
//        this.waivertypeRepository = waivertypeRepository;
//    }

    @Test
    public void testCRUDOperations() throws Exception {
        try{
        // Create a WaiverType

        Waivertype waiverType = new Waivertype();
        waiverType.setName("Test Waiver");
        waiverType.setDescription("Testing");
        waiverType.setDurationindays(10L);
        waiverType.setPercentage(0.05);

            MvcResult createWaiverTypeResult = mockMvc.perform(
                    MockMvcRequestBuilders.post("/api/waivertypes")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(waiverType))
            ).andExpect(status().isCreated()).andReturn();



        Long waiverTypeId = objectMapper.readValue(createWaiverTypeResult.getResponse().getContentAsString(), Waivertype.class).getId();
        Waivertype waivertype=waivertypeRepository.findById(waiverTypeId).get();

        // Create a Loan with the created WaiverType
        Waivers waivers = new Waivers();
        waivers.setId(1L);
        waivers.setLoanId(123L);
        waivers.setCustomerId(456L);
        waivers.setLateFee(500L);
        waivers.setWaivertype(waivertype);

//        waivers.setWaivertype(waiverTypeId);
//        waivers.setWaivertype(waiverTypeId);

        MvcResult createLoanResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/waivers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(waiverType))
        ).andExpect(status().isCreated()).andReturn();

        Long waiverId = objectMapper.readValue(createLoanResult.getResponse().getContentAsString(), Waivers.class).getId();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/waivers/{waiverId}", waiverId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loanId").value(waivers.getLoanId()))
                .andExpect(jsonPath("$.customerId").value(waivers.getCustomerId()))
                .andExpect(jsonPath("$.lateFee").value(waivers.getLateFee()))
                .andExpect(jsonPath("$.waiverType.waiverId").value(waiverTypeId.intValue()));
        }catch(Exception e){
            e.printStackTrace();
        }

//    @Test
//    public void testAddShouldReturn400BadRequest() throws Exception {
//
//        Waivers newWaiver=new Waivers().loanId().customerId().lateFee();
//
//        String requestBody = objectMapper.writeValueAsString(newWaiver);
//
//        mockMvc.perform((RequestBuilder) post(END_POINT_PATH).contentType(MediaType.valueOf("application/json"))
//                        .contentType(MediaType.valueOf(requestBody)))
//                .andExpect(status().isBadRequest())
//                .andDo(print())
//        ;
//    }


    }
}