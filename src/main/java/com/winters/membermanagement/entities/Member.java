package com.winters.membermanagement.entities;

import com.winters.membermanagement.enums.CommitteeType;
import com.winters.membermanagement.enums.OfficeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
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
    private String cellPhone;
    private String homePhone;
    private String officePhone;
    @Column(nullable = false, unique = true)
    private String email;
    private String spouseName;
    private String spousePhone;
    private String spouseEmail;
    private String childrenNames;
    private boolean isOfficeMember;
    private boolean isCommitteeMember;
    private String committeeType;
    private String officeType;
    private double annualDues;

    public void setIsCommitteemember(boolean isCommitteeMember) {
        this.isCommitteeMember = isCommitteeMember;
    }

    public boolean getIsCommitteeMember(){
        return this.isCommitteeMember;
    }

    public void setIsOfficeMember(boolean isOfficeMember) {
        this.isOfficeMember = isOfficeMember;
    }

    public boolean getIsOfficeMember(){
        return this.isOfficeMember;
    }



}
