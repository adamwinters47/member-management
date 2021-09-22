package com.winters.membermanagement.repository;

import com.winters.membermanagement.entities.Slip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlipRepository extends CrudRepository<Slip, Long> {}
