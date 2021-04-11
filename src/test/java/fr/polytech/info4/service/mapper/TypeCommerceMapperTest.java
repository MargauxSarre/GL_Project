package fr.polytech.info4.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TypeCommerceMapperTest {

    private TypeCommerceMapper typeCommerceMapper;

    @BeforeEach
    public void setUp() {
        typeCommerceMapper = new TypeCommerceMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(typeCommerceMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(typeCommerceMapper.fromId(null)).isNull();
    }
}
