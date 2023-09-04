package com.example.Waivers.Controllers;

import com.example.Waivers.Entities.Waivertype;

import com.example.Waivers.Services.WaivertypeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waivertypes")

public class WaiverTypeController {
    WaivertypeService waivertypeService;
    public WaiverTypeController(WaivertypeService waivertypeService){
        this.waivertypeService=waivertypeService;

    }

    @GetMapping
    public ResponseEntity<List<Waivertype>> getAllWaivertypes() {
        List<Waivertype> waivertypes = waivertypeService.getWaiverTypes();
        return new ResponseEntity<>(waivertypes, HttpStatus.OK);
    }

    @GetMapping({"/{waiverTypeId}"})
    public ResponseEntity<Waivertype> getaWaivertype(@PathVariable Long waiverTypeId) {
        return new ResponseEntity<>(waivertypeService.getWaivertypeById(waiverTypeId), HttpStatus.OK);
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Waivertype> saveWaivertype(@RequestBody Waivertype waivertype) {
        Waivertype savedwaiverType = waivertypeService.insert(waivertype);
        return new ResponseEntity<>(savedwaiverType, HttpStatus.CREATED);

    }

    @PutMapping({"/{waiverTypeId}"})
    public ResponseEntity<Waivertype> updateWaiverType(@PathVariable("waiverTypeId") Long waiverTypeId, @RequestBody Waivertype waivertype) {
      waivertypeService.updateWaivertype(waiverTypeId, waivertype);

        return new ResponseEntity<>(waivertypeService.getWaivertypeById(waiverTypeId), HttpStatus.OK);


    }


}





