package com.winters.membermanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "boat")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String boatName;
    private String boatModel;
    private int length;
    private int beam;
    private int depth;
    private String registration;
    private boolean isBoatRegistrationCurrent;
    private boolean isCityRegistrationCurrent;
    @OneToOne
    Slip slip;
    @ManyToOne
    private Member member;

    public void setIsBoatRegistrationCurrent(boolean isBoatRegistrationCurrent){
        this.isBoatRegistrationCurrent = isBoatRegistrationCurrent;
    }

    public boolean getIsBoatRegistrationCurrent(){
        return this.isBoatRegistrationCurrent;
    }

    public void setIsCityRegistrationCurrent(boolean isCityRegistrationCurrent) {
        this.isCityRegistrationCurrent = isCityRegistrationCurrent;
    }

    public boolean getIsCityRegistrationCurrent() {
        return this.isCityRegistrationCurrent;
    }

    public long getMemberId() {
        return this.member.getId();
    }

}
