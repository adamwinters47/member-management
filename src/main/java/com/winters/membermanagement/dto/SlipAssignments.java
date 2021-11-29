package com.winters.membermanagement.dto;


import com.winters.membermanagement.entities.Dock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SlipAssignments {
    private Long boatId;
    private String boatName;
    private String boatModel;
    private Long slipId;
    private Integer slipNum;
    private Dock dock;
}
