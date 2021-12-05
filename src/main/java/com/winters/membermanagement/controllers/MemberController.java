package com.winters.membermanagement.controllers;

import com.winters.membermanagement.dto.MemberDirectoryEntry;
import com.winters.membermanagement.entities.Member;
import com.winters.membermanagement.enums.CommitteeType;
import com.winters.membermanagement.enums.OfficeType;
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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://boatclubmanagement.s3.amazonaws.com/")
@RequestMapping("/member")
class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member test(){
        return Member.builder()
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
                .officePhone("123-456-7890")
                .homePhone("123-456-7890")
                .spouseName("Kelsey")
                .spouseEmail("spouseEmail@test.com")
                .spousePhone("405-962-8844")
                .childrenNames("Fitz, Amber")
                .build();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Member> saveMember(@RequestBody Member member){
        System.out.println(member);
        return new ResponseEntity<>(memberService.saveMember(member), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public @ResponseBody
    ResponseEntity<Member> getById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(memberService.getMemberById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value="/get")
    public @ResponseBody
    ResponseEntity<List<Member>> getAllMembers(){
        return new ResponseEntity<>(memberService.getAllMembers(), HttpStatus.OK);
    }

    @GetMapping(value="/getEntries")
    public @ResponseBody
    ResponseEntity<List<MemberDirectoryEntry>> getAllMemberEntries(){
        return new ResponseEntity<>(memberService.getAllDirectoryEntries(), HttpStatus.OK);
    }

    @DeleteMapping(value="/remove/{id}")
    public @ResponseBody
    ResponseEntity<Long> deleteMemberById(@PathVariable Long id) {
        boolean isDeleted = memberService.deleteMemberById(id);
        return isDeleted ? new ResponseEntity<>(id, HttpStatus.OK) : new ResponseEntity<>(id, HttpStatus.BAD_REQUEST);
    }

}
