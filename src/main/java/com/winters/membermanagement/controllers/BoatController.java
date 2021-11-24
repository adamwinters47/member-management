package com.winters.membermanagement.controllers;

import com.winters.membermanagement.entities.Boat;
import com.winters.membermanagement.entities.Member;
import com.winters.membermanagement.enums.CommitteeType;
import com.winters.membermanagement.enums.OfficeType;
import com.winters.membermanagement.services.BoatService;
import com.winters.membermanagement.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/boat")
@CrossOrigin(origins = "http://localhost:4200")
class BoatController {

    @Autowired
    BoatService boatService;

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boat test() {
        Member savedMember = memberService.saveMember(
                Member.builder()
                .annualDues(100)
                .officeType(OfficeType.BOAT_OFFICE.name())
                .committeeType(CommitteeType.BOAT_COMMITTEE.name())
                .isCommitteeMember(true)
                .isOfficeMember(false)
                .address("123 Fake Street")
                .lastName("Winters")
                .firstName("Adam")
                .email("test@gmail.com")
                .cellPhone("123-456-7890")
                .homePhone("123-456-7890")
                .officePhone("123-456-7890")
                .spouseName("Kelsey")
                .build()
        );

        return Boat.builder()
                .isCityRegistrationCurrent(true)
                .beam(25)
                .depth(15)
                .length(20)
                .isBoatRegistrationCurrent(true)
                .registration("registration")
                .member(savedMember)
                .build();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Boat> saveBoat(@RequestBody Boat boat) {
        System.out.println(boat);
        return new ResponseEntity<>(boatService.saveBoat(boat), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public @ResponseBody
    ResponseEntity<Boat> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(boatService.getBoatById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get/member/{memberId}")
    public @ResponseBody
    ResponseEntity<List<Boat>> getBoatsByMemberId(@PathVariable Long memberId){
        try {
            return new ResponseEntity<>(boatService.getBoatsByMemberId(memberId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get")
    public @ResponseBody
    ResponseEntity<List<Boat>> getAllBoats() {
        return new ResponseEntity<>(boatService.getAllBoats(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove/{id}")
    public @ResponseBody
    ResponseEntity<Long> deleteBoatById(@PathVariable Long id) {
        boolean isDeleted = memberService.deleteMemberById(id);
        return isDeleted ? new ResponseEntity<>(id, HttpStatus.OK) : new ResponseEntity<>(id, HttpStatus.BAD_REQUEST);
    }

}
