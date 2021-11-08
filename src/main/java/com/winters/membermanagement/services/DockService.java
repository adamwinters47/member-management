package com.winters.membermanagement.services;

import com.winters.membermanagement.entities.Dock;
import com.winters.membermanagement.repository.DockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DockService {

    @Autowired
    DockRepository dockRepository;

    public Dock saveDock(Dock dock) { return dockRepository.save(dock); }

    public Dock getDockById(Long id) throws Exception {
        Optional<Dock> dock = dockRepository.findById(id);
        if(dock.isPresent()){
            return dock.get();
        } else {
            throw new Exception("No Entry found for id [" + id + "]");
        }
    }

    public List<Dock> getAllDocks() {
        return (List<Dock>) dockRepository.findAll();
    }

    public boolean deleteDockById(Long id) {
        dockRepository.deleteById(id);
        return dockRepository.existsById(id);
    }
}
