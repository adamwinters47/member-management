package com.winters.membermanagement.controllers;

import com.winters.membermanagement.entities.Dock;
import com.winters.membermanagement.services.DockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/dock")
class DockController {

    @Autowired
    DockService dockService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Dock test() {
        return Dock.builder()
                .dockName("TestDock")
                .build();
    }

    @PostMapping("/save")
    public ResponseEntity<Dock> saveDock(@RequestBody Dock dock) {
        return new ResponseEntity<>(dockService.saveDock(dock), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public @ResponseBody
    ResponseEntity<Dock> getById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(dockService.getDockById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get")
    public @ResponseBody
    ResponseEntity<List<Dock>> getAllDocks() {
        return new ResponseEntity<>(dockService.getAllDocks(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove/{id}")
    public @ResponseBody
    ResponseEntity<Long> deleteDockById(@PathVariable Long id) {
        boolean isDeleted = dockService.deleteDockById(id);
        if(isDeleted) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.BAD_REQUEST);
    }

}
