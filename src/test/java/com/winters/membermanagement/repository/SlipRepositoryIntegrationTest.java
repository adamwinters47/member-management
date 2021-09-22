package com.winters.membermanagement.repository;

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
public class SlipRepositoryIntegrationTest {

    @Autowired
    SlipRepository slipRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfSlips() {
        Slip slip = Slip.builder()
                .slipType(SlipType.WET)
                .length(50)
                .width(100)
                .build();

        slipRepository.save(slip);

        List<Slip> slips = (List<Slip>) slipRepository.findAll();

        slips.forEach(System.out::println);

        assertThat(slips.size()).isEqualTo(1);

        Slip returnedSlip = slips.get(0);
        assertThat(returnedSlip.getId()).isNotNull();
        assertThat(returnedSlip.getSlipType()).isNotNull();
        assertThat(returnedSlip.getLength()).isNotNull();
        assertThat(returnedSlip.getWidth()).isNotNull();
    }
}
