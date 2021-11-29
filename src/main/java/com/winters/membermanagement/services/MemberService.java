package com.winters.membermanagement.services;

import com.winters.membermanagement.entities.Boat;
import com.winters.membermanagement.entities.Member;
import com.winters.membermanagement.repository.BoatRepository;
import com.winters.membermanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private Map<Long, List<Boat>> assembleBoatMap(List<Boat> boatList) {
        Map<Long, List<Boat>> result = new HashMap();
        for(Boat boat: boatList) {
            if(boat.getMember() != null){
                if(result.containsKey(boat.getMemberId())){
                    List<Boat> boats = result.get(boat.getMemberId());
                    boats.add(boat);
                    result.put(boat.getMemberId(), boats);
                } else {
                    result.put(boat.getMemberId(), Collections.singletonList(boat));
                }
            }
        }
        return result;
    }
}
