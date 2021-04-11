package fr.polytech.info4.service.mapper;


import fr.polytech.info4.domain.*;
import fr.polytech.info4.service.dto.RestaurantDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Restaurant} and its DTO {@link RestaurantDTO}.
 */
@Mapper(componentModel = "spring", uses = {CompteMapper.class, TypeCommerceMapper.class})
public interface RestaurantMapper extends EntityMapper<RestaurantDTO, Restaurant> {

    @Mapping(source = "compte.id", target = "compteId")
    RestaurantDTO toDto(Restaurant restaurant);

    @Mapping(source = "compteId", target = "compte")
    @Mapping(target = "removeTypeCommerce", ignore = true)
    Restaurant toEntity(RestaurantDTO restaurantDTO);

    default Restaurant fromId(Long id) {
        if (id == null) {
            return null;
        }
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);
        return restaurant;
    }
}
