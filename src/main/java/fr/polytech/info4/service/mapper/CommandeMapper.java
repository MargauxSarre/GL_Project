package fr.polytech.info4.service.mapper;


import fr.polytech.info4.domain.*;
import fr.polytech.info4.service.dto.CommandeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Commande} and its DTO {@link CommandeDTO}.
 */
@Mapper(componentModel = "spring", uses = {CourseMapper.class, CompteMapper.class, RestaurantMapper.class, ProduitMapper.class})
public interface CommandeMapper extends EntityMapper<CommandeDTO, Commande> {

    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "compte.id", target = "compteId")
    @Mapping(source = "restaurant.id", target = "restaurantId")
    CommandeDTO toDto(Commande commande);

    @Mapping(source = "courseId", target = "course")
    @Mapping(source = "compteId", target = "compte")
    @Mapping(source = "restaurantId", target = "restaurant")
    @Mapping(target = "removeProduit", ignore = true)
    Commande toEntity(CommandeDTO commandeDTO);

    default Commande fromId(Long id) {
        if (id == null) {
            return null;
        }
        Commande commande = new Commande();
        commande.setId(id);
        return commande;
    }
}
