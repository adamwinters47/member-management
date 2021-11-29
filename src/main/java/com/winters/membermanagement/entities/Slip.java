package com.winters.membermanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

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
    private Integer slipNum;
    private BigDecimal length;
    private BigDecimal width;
    private String slipType;
    @Column(columnDefinition = "boolean default false")
    private boolean isAssigned;
    @OneToOne
    @JoinColumn(name = "dock_id", referencedColumnName = "id")
    Dock dock;


}
