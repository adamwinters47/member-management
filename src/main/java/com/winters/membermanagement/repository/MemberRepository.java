package com.winters.membermanagement.repository;

import com.winters.membermanagement.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    Page<Member> findAll(Pageable pageable);
}
