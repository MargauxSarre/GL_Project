package fr.polytech.info4.web.rest;

import fr.polytech.info4.service.TypeCommerceService;
import fr.polytech.info4.web.rest.errors.BadRequestAlertException;
import fr.polytech.info4.service.dto.TypeCommerceDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link fr.polytech.info4.domain.TypeCommerce}.
 */
@RestController
@RequestMapping("/api")
public class TypeCommerceResource {

    private final Logger log = LoggerFactory.getLogger(TypeCommerceResource.class);

    private static final String ENTITY_NAME = "typeCommerce";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TypeCommerceService typeCommerceService;

    public TypeCommerceResource(TypeCommerceService typeCommerceService) {
        this.typeCommerceService = typeCommerceService;
    }

    /**
     * {@code POST  /type-commerces} : Create a new typeCommerce.
     *
     * @param typeCommerceDTO the typeCommerceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new typeCommerceDTO, or with status {@code 400 (Bad Request)} if the typeCommerce has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/type-commerces")
    public ResponseEntity<TypeCommerceDTO> createTypeCommerce(@Valid @RequestBody TypeCommerceDTO typeCommerceDTO) throws URISyntaxException {
        log.debug("REST request to save TypeCommerce : {}", typeCommerceDTO);
        if (typeCommerceDTO.getId() != null) {
            throw new BadRequestAlertException("A new typeCommerce cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TypeCommerceDTO result = typeCommerceService.save(typeCommerceDTO);
        return ResponseEntity.created(new URI("/api/type-commerces/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /type-commerces} : Updates an existing typeCommerce.
     *
     * @param typeCommerceDTO the typeCommerceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated typeCommerceDTO,
     * or with status {@code 400 (Bad Request)} if the typeCommerceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the typeCommerceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/type-commerces")
    public ResponseEntity<TypeCommerceDTO> updateTypeCommerce(@Valid @RequestBody TypeCommerceDTO typeCommerceDTO) throws URISyntaxException {
        log.debug("REST request to update TypeCommerce : {}", typeCommerceDTO);
        if (typeCommerceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TypeCommerceDTO result = typeCommerceService.save(typeCommerceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, typeCommerceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /type-commerces} : get all the typeCommerces.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of typeCommerces in body.
     */
    @GetMapping("/type-commerces")
    public List<TypeCommerceDTO> getAllTypeCommerces() {
        log.debug("REST request to get all TypeCommerces");
        return typeCommerceService.findAll();
    }

    /**
     * {@code GET  /type-commerces/:id} : get the "id" typeCommerce.
     *
     * @param id the id of the typeCommerceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the typeCommerceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/type-commerces/{id}")
    public ResponseEntity<TypeCommerceDTO> getTypeCommerce(@PathVariable Long id) {
        log.debug("REST request to get TypeCommerce : {}", id);
        Optional<TypeCommerceDTO> typeCommerceDTO = typeCommerceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(typeCommerceDTO);
    }

    /**
     * {@code DELETE  /type-commerces/:id} : delete the "id" typeCommerce.
     *
     * @param id the id of the typeCommerceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/type-commerces/{id}")
    public ResponseEntity<Void> deleteTypeCommerce(@PathVariable Long id) {
        log.debug("REST request to delete TypeCommerce : {}", id);
        typeCommerceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
