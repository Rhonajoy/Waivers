package com.example.Waivers;

import com.example.Waivers.Controllers.WaiverTypeController;
import com.example.Waivers.Controllers.WaiversController;
import com.example.Waivers.DTO.WaiverRequest;
import com.example.Waivers.DTO.WaiverTypeRequest;
import com.example.Waivers.Entities.Waivers;
import com.example.Waivers.Entities.Waivertype;
import com.example.Waivers.Services.WaiversService;
import com.example.Waivers.Services.WaivertypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class WaiverTypeControllerTests {
    @InjectMocks
    private WaiverTypeController waiverTypeController;

        @Mock
        private WaivertypeService waivertypeService;@Test

        public void testSaveWaiverType() {
            WaiverTypeRequest waiverTypeRequest = TestUtil.createWaivertypeRequest();
          ;Waivertype waivertype = TestUtil.createWaiverType();
            doReturn(waivertype).when(waivertypeService).insert(waiverTypeRequest);
            ResponseEntity<Waivertype> response = waiverTypeController.saveWaivertype(waiverTypeRequest);
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(waivertype, response.getBody());
        }

        @Test
        public void testGetAWaiverType() {
            Long waiverTypeId = 1L;
            Waivertype foundWaiverType = TestUtil.createWaiverType();
            when(waivertypeService.getWaivertypeById(waiverTypeId)).thenReturn(foundWaiverType);
            ResponseEntity<Waivertype> response = waiverTypeController.getaWaivertype(waiverTypeId);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(foundWaiverType, response.getBody());
        }

        @Test
        public void testGetWaiverTypes() {
            List<Waivertype> allWaiverTypes = new ArrayList<>();
            doReturn(allWaiverTypes).when(waivertypeService).getWaiverTypes();
            ResponseEntity response = waiverTypeController.getAllWaivertypes();
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(allWaiverTypes, response.getBody());
        }

        @Test
        public void testUpdateWaiverType() {
            Long waiverId = 1L;
            Waivertype updatedWaiverType = TestUtil.createWaiverType();
            ResponseEntity<Waivertype> response = waiverTypeController.updateWaiverType(waiverId,updatedWaiverType);
            assertEquals(HttpStatus.OK, response.getStatusCode());

        }


}