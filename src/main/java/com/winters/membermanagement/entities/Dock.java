package com.winters.membermanagement.entities;

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
@Table(name = "dock")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dockName;
}
