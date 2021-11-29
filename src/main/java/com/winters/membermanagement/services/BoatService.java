package com.winters.membermanagement.services;

import com.winters.membermanagement.entities.Boat;
import com.winters.membermanagement.entities.Member;
import com.winters.membermanagement.repository.BoatRepository;
import com.winters.membermanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BoatService {

    @Autowired
    BoatRepository boatRepository;

    @Autowired
    MemberRepository memberRepository;

    public Boat saveBoat(Boat boat) { return boatRepository.save(boat); }

    public Boat getBoatById(Long id) throws Exception {
        Optional<Boat> boat = boatRepository.findById(id);
        if(boat.isPresent()) {
            return boat.get();
        } else {
            throw new Exception("No Entry found for id [" + id + "]");
        }
    }

    public List<Boat> getAllBoats() {
        return (List<Boat>) boatRepository.findAll();
    }

    public List<Boat> getBoatsByMemberId(Long memberId) {

        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isPresent()){
            return boatRepository.findByMember(member.get());
        } else {
            return Collections.emptyList();
        }
    }

    public Boat assignSlip(Long slipId) {
        //TODO: Pull Slip from slip repo, change isAssigned to True, save slip, save Boat with new slip
        return new Boat();
    }

    //TODO: removeSlip does opposite of assignSlip

    public boolean deleteBoatById(Long id) {
        boatRepository.deleteById(id);
        return boatRepository.existsById(id);
    }
}
