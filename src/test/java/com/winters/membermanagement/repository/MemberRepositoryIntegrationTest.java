package com.winters.membermanagement.repository;

import com.winters.membermanagement.entities.Member;
import com.winters.membermanagement.enums.CommitteeType;
import com.winters.membermanagement.enums.OfficeType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryIntegrationTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfMembers() {
        Member member = Member.builder()
                .firstName("FirstName")
                .lastName("LastName")
                .address("Address")
                .phone("Phone")
                .email("Email")
                .spouseName("SpouseName")
                .isOfficeMember(false)
                .isCommitteeMember(true)
                .committeeType(CommitteeType.BOAT_COMMITTEE)
                .officeType(OfficeType.BOAT_OFFICE)
                .annualDues(5000L)
                .build();

        memberRepository.save(member);
        List<Member> members = (List<Member>) memberRepository.findAll();

        members.forEach(System.out::println);

        assertThat(members.size()).isEqualTo(1);

        Member returnedMember = members.get(0);

        assertThat(returnedMember.getId()).isNotNull();
        assertThat(returnedMember.getFirstName()).isNotNull();
        assertThat(returnedMember.getLastName()).isNotNull();
        assertThat(returnedMember.getAddress()).isNotNull();
        assertThat(returnedMember.getPhone()).isNotNull();
        assertThat(returnedMember.getEmail()).isNotNull();
        assertThat(returnedMember.getSpouseName()).isNotNull();
        assertThat(returnedMember.isOfficeMember()).isNotNull();
        assertThat(returnedMember.isCommitteeMember()).isNotNull();
        assertThat(returnedMember.getCommitteeType()).isNotNull();
        assertThat(returnedMember.getOfficeType()).isNotNull();
        assertThat(returnedMember.getAnnualDues()).isNotNull();
    }
}
