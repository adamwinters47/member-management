package com.winters.membermanagement.repository;

import com.winters.membermanagement.entities.Boat;
import com.winters.membermanagement.entities.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoatRepository extends CrudRepository<Boat, Long> {

    List<Boat> findByMember(Member member);
}
