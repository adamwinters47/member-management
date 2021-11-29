package com.winters.membermanagement.controllers;

import com.winters.membermanagement.dto.SlipAssignments;
import com.winters.membermanagement.entities.Slip;
import com.winters.membermanagement.services.SlipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/slip")
class SlipController {

    @Autowired
    SlipService slipService;

    @GetMapping(value="/get")
    public @ResponseBody
    ResponseEntity<List<Slip>> getAllSlips() {
        return new ResponseEntity<>(slipService.getAllSlips(), HttpStatus.OK);
    }

    @GetMapping(value="/getAssignments")
    public @ResponseBody
    ResponseEntity<List<SlipAssignments>> getSlipAssignments() {
        return new ResponseEntity<>(slipService.getAllSlipAssignments(), HttpStatus.OK);
    }

    @PostMapping(value = "/assign")
    public @ResponseBody ResponseEntity<SlipAssignments> assign(@RequestBody SlipAssignments slipAssignment) {
        System.out.println(slipAssignment);
        return new ResponseEntity<>(slipService.assign(slipAssignment), HttpStatus.OK);
    }

    @PostMapping(value = "/unassign")
    public @ResponseBody ResponseEntity<SlipAssignments> unassign(@RequestBody SlipAssignments slipAssignment) {
        System.out.println(slipAssignment);
        return new ResponseEntity<>(slipService.unassign(slipAssignment), HttpStatus.OK);
    }

}
