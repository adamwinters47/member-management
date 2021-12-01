package com.winters.membermanagement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@Builder
public class MemberDirectoryEntry {

    private Long memberId;
    private String firstName;
    private String lastName;
    private String address;
    private String cellPhone;
    private String homePhone;
    private String officePhone;
    private String email;
    private String spouseName;
    private String spousePhone;
    private String spouseEmail;
    private String childrenNames;
    private boolean isOfficeMember;
    private boolean isCommitteeMember;
    private String committeeType;
    private String officeType;
    private List<BoatDirectoryEntry> boatList;



}
