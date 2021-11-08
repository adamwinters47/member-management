package com.winters.membermanagement.services;

import com.winters.membermanagement.entities.Boat;
import com.winters.membermanagement.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {

    @Autowired
    BoatRepository boatRepository;

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

    public boolean deleteBoatById(Long id) {
        boatRepository.deleteById(id);
        return boatRepository.existsById(id);
    }
}
