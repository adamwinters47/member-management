package com.winters.membermanagement.services;

import com.winters.membermanagement.dto.BoatDirectoryEntry;
import com.winters.membermanagement.dto.MemberDirectoryEntry;
import com.winters.membermanagement.entities.Boat;
import com.winters.membermanagement.entities.Member;
import com.winters.membermanagement.repository.BoatRepository;
import com.winters.membermanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BoatRepository boatRepository;

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public Member getMemberById(Long id) throws Exception {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()){
            return member.get();
        } else {
            throw new Exception("No Entry found for id [" + id + "]");
        }
    }

    public List<Member> getAllMembers(){
        List<Member> memberList = (List<Member>) memberRepository.findAll();
        memberList.sort((o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()));
        return memberList;
    }

    public boolean deleteMemberById(Long id) {
        memberRepository.deleteById(id);
        return memberRepository.existsById(id);
    }

    public List<MemberDirectoryEntry> getAllDirectoryEntries() {
        List<Member> members = (List<Member>) memberRepository.findAll();
        List<Boat> boats = (List<Boat>) boatRepository.findAll();
        Map<Long, List<Boat>> boatsByMemberId = assembleBoatMap(boats);

        List<MemberDirectoryEntry> result = new ArrayList<>();
        for(Member member : members) {
            MemberDirectoryEntry memberDirectoryEntry = buildMemberDirectoryInfo(member);
            if(boatsByMemberId.containsKey(member.getId())){
                List<BoatDirectoryEntry> boatDirectoryEntries = buildBoatDirectoryEntries(boatsByMemberId.get(member.getId()));
                memberDirectoryEntry.setBoatList(boatDirectoryEntries);
            }
            result.add(memberDirectoryEntry);
        }
        return result;
    }

    private List<BoatDirectoryEntry> buildBoatDirectoryEntries(List<Boat> boats) {
        List<BoatDirectoryEntry> result = new ArrayList<>();
        for(Boat boat : boats) {
            BoatDirectoryEntry boatDirectoryEntry = BoatDirectoryEntry.builder()
                    .boatId(boat.getId())
                    .boatName(boat.getBoatName())
                    .boatModel(boat.getBoatModel())
                    .length(boat.getLength())
                    .beam(boat.getBeam())
                    .depth(boat.getDepth())
                    .registration(boat.getRegistration())
                    .isBoatRegistrationCurrent(boat.getIsBoatRegistrationCurrent())
                    .isCityRegistrationCurrent(boat.getIsCityRegistrationCurrent())
                    .build();
            result.add(boatDirectoryEntry);
        }
        return result;
    }

    private MemberDirectoryEntry buildMemberDirectoryInfo(Member member) {
        return MemberDirectoryEntry.builder()
                .memberId(member.getId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .address(member.getAddress())
                .cellPhone(member.getCellPhone())
                .homePhone(member.getHomePhone())
                .officePhone(member.getOfficePhone())
                .email(member.getEmail())
                .spouseName(member.getSpouseName())
                .spousePhone(member.getSpousePhone())
                .spouseEmail(member.getSpouseEmail())
                .childrenNames(member.getChildrenNames())
                .isOfficeMember(member.getIsOfficeMember())
                .yearOfficeHeld(member.getYearOfficeHeld())
                .isCommitteeMember(member.getIsCommitteeMember())
                .committeeType(member.getCommitteeType())
                .officeType(member.getOfficeType())
                .build();
    }

    private Map<Long, List<Boat>> assembleBoatMap(List<Boat> boatList) {
        Map<Long, List<Boat>> result = new HashMap();
        for(Boat boat: boatList) {
            if(boat.getMember() != null){
                if(result.containsKey(boat.getMemberId())){
                    List<Boat> boats = result.get(boat.getMemberId());
                    boats.add(boat);
                    result.put(boat.getMemberId(), boats);
                } else {
                    result.put(boat.getMemberId(), new ArrayList<Boat>(Arrays.asList(boat)));
                }
            }
        }
        return result;
    }
}
