package com.winters.membermanagement.repository;

import com.winters.membermanagement.entities.Boat;
import com.winters.membermanagement.entities.Slip;
import com.winters.membermanagement.enums.SlipType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BoatRepositoryIntegrationTest {

    @Autowired
    private BoatRepository boatRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfBoats() {
        Boat boat = Boat.builder()
                .isBoatRegistrationCurrent(true)
                .isCityRegistrationCurrent(true)
                .beam(50)
                .depth(100)
                .length(150)
                .registration("Registration")
                .build();
        boatRepository.save(boat);
        List<Boat> boats = (List<Boat>) boatRepository.findAll();

        boats.forEach(System.out::println);

        assertThat(boats.size()).isEqualTo(1);

        Boat returnedBoat = boats.get(0);
        assertThat(returnedBoat.getId()).isNotNull();
        assertThat(returnedBoat.getBeam()).isNotNull();
        assertThat(returnedBoat.getDepth()).isNotNull();
        assertThat(returnedBoat.getLength()).isNotNull();
        assertThat(returnedBoat.getRegistration()).isNotNull();
        assertThat(returnedBoat.isBoatRegistrationCurrent()).isNotNull();
        assertThat(returnedBoat.isCityRegistrationCurrent()).isNotNull();
        assertThat(returnedBoat.getSlip()).isNotNull();
    }
}
