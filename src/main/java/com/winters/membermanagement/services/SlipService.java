package com.winters.membermanagement.services;


import com.winters.membermanagement.dto.SlipAssignments;
import com.winters.membermanagement.entities.Boat;
import com.winters.membermanagement.entities.Slip;
import com.winters.membermanagement.repository.BoatRepository;
import com.winters.membermanagement.repository.DockRepository;
import com.winters.membermanagement.repository.SlipRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SlipService {

    @Autowired
    SlipRepository slipRepository;

    @Autowired
    BoatRepository boatRepository;

    @Autowired
    DockRepository dockRepository;

    public List<Slip> getAllSlips() {
        List<Slip> slips = (List<Slip>) slipRepository.findAll();
        slips.sort((o1, o2) -> formatSlipName(o1).compareToIgnoreCase(formatSlipName(o2)));
        return slips;
    }

    public List<SlipAssignments> getAllSlipAssignments() {
        List<Slip> slips = (List<Slip>) slipRepository.findAll();
        List<Boat> boats = (List<Boat>) boatRepository.findAll();

        Map<Long, Boat> boatMap = mapBoatBySlipId(boats);
        List<SlipAssignments> result = mapToSlipAssignments(slips, boatMap);

        return result;
    }

    public SlipAssignments assign(SlipAssignments slipAssignment) {

        Optional<Slip> slip = slipRepository.findById(slipAssignment.getSlipId());
        Slip savedSlip = null;
        if(slip.isPresent()){
            Slip presentSlip = slip.get();
            presentSlip.setAssigned(true);
            savedSlip = slipRepository.save(presentSlip);
        }

        Optional<Boat> boat = boatRepository.findById(slipAssignment.getBoatId());
        if(boat.isPresent()){
            Boat presentBoat = boat.get();
            if(savedSlip != null) {
                presentBoat.setSlip(savedSlip);
                boatRepository.save(presentBoat);
            }
        }
        return slipAssignment;
    }

    public SlipAssignments unassign(SlipAssignments slipAssignment) {
        Optional<Slip> slip = slipRepository.findById(slipAssignment.getSlipId());
        if(slip.isPresent()){
            Slip presentSlip = slip.get();
            presentSlip.setAssigned(false);
            slipRepository.save(presentSlip);
        }

        Optional<Boat> boat = boatRepository.findById(slipAssignment.getBoatId());
        if(boat.isPresent()){
            Boat presentBoat = boat.get();
                presentBoat.setSlip(null);
                boatRepository.save(presentBoat);
        }
        return slipAssignment;
    }


    private List<SlipAssignments> mapToSlipAssignments(List<Slip> slips, Map<Long, Boat> boatMap){
        List<SlipAssignments> result = new ArrayList<>();
        for(Slip slip : slips) {
            boolean containsBoat = boatMap.containsKey(slip.getId());
            result.add(SlipAssignments.builder()
                    .slipId(slip.getId())
                    .boatId(containsBoat ? boatMap.get(slip.getId()).getId() : null )
                    .boatName(containsBoat ? boatMap.get(slip.getId()).getBoatName() : null)
                    .boatModel(containsBoat ? boatMap.get(slip.getId()).getBoatModel() : null)
                    .dock(slip.getDock())
                    .slipNum(slip.getSlipNum())
                    .build());
        }
        return result;
    }

    private Map<Long, Boat> mapBoatBySlipId(List<Boat> boats) {
        Map<Long, Boat> boatMap = new HashMap<>();
        for(Boat boat: boats) {
            if(boat.getSlip() != null) {
                boatMap.put(boat.getSlip().getId(), boat);
            }
        }
        return boatMap;
    }

    private String formatSlipName(Slip slip) {
        String slipNum = slip.getSlipNum().toString();
        if(slip.getSlipNum() < 10) {
            slipNum = "0" + slip.getSlipNum();
        }
        String result = slip.getDock().getDockName() + slipNum;
        return result;
    }
}
