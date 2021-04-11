package fr.polytech.info4.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import fr.polytech.info4.web.rest.TestUtil;

public class TypeCommerceDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TypeCommerceDTO.class);
        TypeCommerceDTO typeCommerceDTO1 = new TypeCommerceDTO();
        typeCommerceDTO1.setId(1L);
        TypeCommerceDTO typeCommerceDTO2 = new TypeCommerceDTO();
        assertThat(typeCommerceDTO1).isNotEqualTo(typeCommerceDTO2);
        typeCommerceDTO2.setId(typeCommerceDTO1.getId());
        assertThat(typeCommerceDTO1).isEqualTo(typeCommerceDTO2);
        typeCommerceDTO2.setId(2L);
        assertThat(typeCommerceDTO1).isNotEqualTo(typeCommerceDTO2);
        typeCommerceDTO1.setId(null);
        assertThat(typeCommerceDTO1).isNotEqualTo(typeCommerceDTO2);
    }
}
