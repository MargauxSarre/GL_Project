package fr.polytech.info4.service.mapper;


import fr.polytech.info4.domain.*;
import fr.polytech.info4.service.dto.AvisDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Avis} and its DTO {@link AvisDTO}.
 */
@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface AvisMapper extends EntityMapper<AvisDTO, Avis> {

    @Mapping(source = "course.id", target = "courseId")
    AvisDTO toDto(Avis avis);

    @Mapping(source = "courseId", target = "course")
    Avis toEntity(AvisDTO avisDTO);

    default Avis fromId(Long id) {
        if (id == null) {
            return null;
        }
        Avis avis = new Avis();
        avis.setId(id);
        return avis;
    }
}
