package fr.polytech.info4.service;

import fr.polytech.info4.domain.Avis;
import fr.polytech.info4.repository.AvisRepository;
import fr.polytech.info4.service.dto.AvisDTO;
import fr.polytech.info4.service.mapper.AvisMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Avis}.
 */
@Service
@Transactional
public class AvisService {

    private final Logger log = LoggerFactory.getLogger(AvisService.class);

    private final AvisRepository avisRepository;

    private final AvisMapper avisMapper;

    public AvisService(AvisRepository avisRepository, AvisMapper avisMapper) {
        this.avisRepository = avisRepository;
        this.avisMapper = avisMapper;
    }

    /**
     * Save a avis.
     *
     * @param avisDTO the entity to save.
     * @return the persisted entity.
     */
    public AvisDTO save(AvisDTO avisDTO) {
        log.debug("Request to save Avis : {}", avisDTO);
        Avis avis = avisMapper.toEntity(avisDTO);
        avis = avisRepository.save(avis);
        return avisMapper.toDto(avis);
    }

    /**
     * Get all the avis.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<AvisDTO> findAll() {
        log.debug("Request to get all Avis");
        return avisRepository.findAll().stream()
            .map(avisMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one avis by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AvisDTO> findOne(Long id) {
        log.debug("Request to get Avis : {}", id);
        return avisRepository.findById(id)
            .map(avisMapper::toDto);
    }

    /**
     * Delete the avis by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Avis : {}", id);
        avisRepository.deleteById(id);
    }
}
