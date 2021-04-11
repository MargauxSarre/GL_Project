package fr.polytech.info4.service.mapper;


import fr.polytech.info4.domain.*;
import fr.polytech.info4.service.dto.CompteDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Compte} and its DTO {@link CompteDTO}.
 */
@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface CompteMapper extends EntityMapper<CompteDTO, Compte> {

    @Mapping(source = "course.id", target = "courseId")
    CompteDTO toDto(Compte compte);

    @Mapping(source = "courseId", target = "course")
    Compte toEntity(CompteDTO compteDTO);

    default Compte fromId(Long id) {
        if (id == null) {
            return null;
        }
        Compte compte = new Compte();
        compte.setId(id);
        return compte;
    }
}
