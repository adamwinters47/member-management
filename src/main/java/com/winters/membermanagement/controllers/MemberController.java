package com.winters.membermanagement.controllers;

import com.winters.membermanagement.entities.Member;
import com.winters.membermanagement.enums.CommitteeType;
import com.winters.membermanagement.enums.OfficeType;
import com.winters.membermanagement.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member test(){
        return Member.builder()
                .annualDues(100)
                .officeType(OfficeType.BOAT_OFFICE)
                .committeeType(CommitteeType.BOAT_COMMITTEE)
                .isCommitteeMember(true)
                .isOfficeMember(false)
                .address("123 Fake Street")
                .lastName("Winters")
                .firstName("Adam")
                .email("test@gmail.com")
                .phone("123-456-7890")
                .spouseName("Kelsey")
                .build();
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Member> saveMember(@RequestBody Member member){
        return new ResponseEntity<>(memberService.saveMember(member), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public @ResponseBody
    ResponseEntity<Member> getById(@PathVariable Long id) {
        try {
            Member resultMember = memberService.getMemberById(id);
            return new ResponseEntity<>(resultMember, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
