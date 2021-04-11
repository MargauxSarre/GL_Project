package fr.polytech.info4.service.mapper;


import fr.polytech.info4.domain.*;
import fr.polytech.info4.service.dto.TypeCommerceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TypeCommerce} and its DTO {@link TypeCommerceDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TypeCommerceMapper extends EntityMapper<TypeCommerceDTO, TypeCommerce> {


    @Mapping(target = "restaurants", ignore = true)
    @Mapping(target = "removeRestaurant", ignore = true)
    TypeCommerce toEntity(TypeCommerceDTO typeCommerceDTO);

    default TypeCommerce fromId(Long id) {
        if (id == null) {
            return null;
        }
        TypeCommerce typeCommerce = new TypeCommerce();
        typeCommerce.setId(id);
        return typeCommerce;
    }
}
