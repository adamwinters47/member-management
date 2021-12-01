package com.winters.membermanagement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoatDirectoryEntry {

    private Long boatId;

    private String boatName;
    private String boatModel;
    private int length;
    private int beam;
    private int depth;
    private String registration;
    private boolean isBoatRegistrationCurrent;
    private boolean isCityRegistrationCurrent;
}
