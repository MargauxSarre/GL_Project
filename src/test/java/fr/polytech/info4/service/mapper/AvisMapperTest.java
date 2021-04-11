package fr.polytech.info4.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AvisMapperTest {

    private AvisMapper avisMapper;

    @BeforeEach
    public void setUp() {
        avisMapper = new AvisMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(avisMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(avisMapper.fromId(null)).isNull();
    }
}
