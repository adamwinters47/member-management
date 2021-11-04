package com.winters.membermanagement.entities;

import com.winters.membermanagement.enums.CommitteeType;
import com.winters.membermanagement.enums.OfficeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String spouseName;
    private boolean isOfficeMember;
    private boolean isCommitteeMember;
    private CommitteeType committeeType;
    private OfficeType officeType;
    private double annualDues;
    @OneToMany(mappedBy = "id")
    private List<Boat> boats;


}
