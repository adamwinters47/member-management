package com.winters.membermanagement.entities;

import com.winters.membermanagement.enums.SlipType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slip")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Slip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int length;
    private int width;
    private SlipType slipType;

}
