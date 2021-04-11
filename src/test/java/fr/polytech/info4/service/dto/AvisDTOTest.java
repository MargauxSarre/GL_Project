package fr.polytech.info4.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import fr.polytech.info4.web.rest.TestUtil;

public class AvisDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AvisDTO.class);
        AvisDTO avisDTO1 = new AvisDTO();
        avisDTO1.setId(1L);
        AvisDTO avisDTO2 = new AvisDTO();
        assertThat(avisDTO1).isNotEqualTo(avisDTO2);
        avisDTO2.setId(avisDTO1.getId());
        assertThat(avisDTO1).isEqualTo(avisDTO2);
        avisDTO2.setId(2L);
        assertThat(avisDTO1).isNotEqualTo(avisDTO2);
        avisDTO1.setId(null);
        assertThat(avisDTO1).isNotEqualTo(avisDTO2);
    }
}
