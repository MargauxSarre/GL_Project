package fr.polytech.info4.service;

import fr.polytech.info4.domain.TypeCommerce;
import fr.polytech.info4.repository.TypeCommerceRepository;
import fr.polytech.info4.service.dto.TypeCommerceDTO;
import fr.polytech.info4.service.mapper.TypeCommerceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link TypeCommerce}.
 */
@Service
@Transactional
public class TypeCommerceService {

    private final Logger log = LoggerFactory.getLogger(TypeCommerceService.class);

    private final TypeCommerceRepository typeCommerceRepository;

    private final TypeCommerceMapper typeCommerceMapper;

    public TypeCommerceService(TypeCommerceRepository typeCommerceRepository, TypeCommerceMapper typeCommerceMapper) {
        this.typeCommerceRepository = typeCommerceRepository;
        this.typeCommerceMapper = typeCommerceMapper;
    }

    /**
     * Save a typeCommerce.
     *
     * @param typeCommerceDTO the entity to save.
     * @return the persisted entity.
     */
    public TypeCommerceDTO save(TypeCommerceDTO typeCommerceDTO) {
        log.debug("Request to save TypeCommerce : {}", typeCommerceDTO);
        TypeCommerce typeCommerce = typeCommerceMapper.toEntity(typeCommerceDTO);
        typeCommerce = typeCommerceRepository.save(typeCommerce);
        return typeCommerceMapper.toDto(typeCommerce);
    }

    /**
     * Get all the typeCommerces.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<TypeCommerceDTO> findAll() {
        log.debug("Request to get all TypeCommerces");
        return typeCommerceRepository.findAll().stream()
            .map(typeCommerceMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one typeCommerce by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TypeCommerceDTO> findOne(Long id) {
        log.debug("Request to get TypeCommerce : {}", id);
        return typeCommerceRepository.findById(id)
            .map(typeCommerceMapper::toDto);
    }

    /**
     * Delete the typeCommerce by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TypeCommerce : {}", id);
        typeCommerceRepository.deleteById(id);
    }
}
