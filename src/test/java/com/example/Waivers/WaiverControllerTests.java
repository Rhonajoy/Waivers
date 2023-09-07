package com.example.Waivers;

import com.example.Waivers.Controllers.WaiversController;
import com.example.Waivers.DTO.WaiverRequest;
import com.example.Waivers.Entities.Waivers;
import com.example.Waivers.Services.WaiversService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WaiverControllerTests {
    @InjectMocks
    private WaiversController waiversController;
    @Mock
    private WaiversService waiversService;

    @Test
    public void testSaveWaiver() {
        WaiverRequest waiverRequest = TestUtil.createWaiverRequest();

        Waivers waivers = TestUtil.createWaiver();

        doReturn(waivers).when(waiversService).insert(waiverRequest);

        ResponseEntity<Waivers> response = waiversController.saveWaiverType(waiverRequest);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(waivers, response.getBody());
    }

    @Test
    public void testGetAWaiver() {
        Long waiverId = 1L;

        Waivers foundWaivers = TestUtil.createWaiver();

        when(waiversService.getWaiverById(waiverId)).thenReturn(foundWaivers);

        // Act
        ResponseEntity<Waivers> response = waiversController.getaWaiver(waiverId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(foundWaivers, response.getBody());
    }

    @Test
    public void testGetWaivers() {
        List<Waivers> allWaivers = new ArrayList<>();
        doReturn(allWaivers).when(waiversService).getallWaivers();
        ResponseEntity response = waiversController.getAllWaivers();
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(allWaivers, response.getBody());
    }

    @Test
    public void testUpdateWaiver() {
        Long waiverId = 1L;

        Waivers updatedWaivers = TestUtil.createWaiver();

//    when(waiversService.updateWaivers(waiverId, updatedWaivers)).thenReturn(updatedWaivers);

        ResponseEntity<Waivers> response = waiversController.updateWaiver(waiverId, updatedWaivers);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
//    assertEquals(updatedWaivers, response.getBody());
    }


}