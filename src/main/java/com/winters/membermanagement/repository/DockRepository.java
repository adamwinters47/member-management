package com.winters.membermanagement.repository;

import com.winters.membermanagement.entities.Dock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DockRepository extends CrudRepository<Dock, Long> {}
