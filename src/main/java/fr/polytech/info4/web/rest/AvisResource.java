package fr.polytech.info4.web.rest;

import fr.polytech.info4.service.AvisService;
import fr.polytech.info4.web.rest.errors.BadRequestAlertException;
import fr.polytech.info4.service.dto.AvisDTO;

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
 * REST controller for managing {@link fr.polytech.info4.domain.Avis}.
 */
@RestController
@RequestMapping("/api")
public class AvisResource {

    private final Logger log = LoggerFactory.getLogger(AvisResource.class);

    private static final String ENTITY_NAME = "avis";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AvisService avisService;

    public AvisResource(AvisService avisService) {
        this.avisService = avisService;
    }

    /**
     * {@code POST  /avis} : Create a new avis.
     *
     * @param avisDTO the avisDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new avisDTO, or with status {@code 400 (Bad Request)} if the avis has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/avis")
    public ResponseEntity<AvisDTO> createAvis(@Valid @RequestBody AvisDTO avisDTO) throws URISyntaxException {
        log.debug("REST request to save Avis : {}", avisDTO);
        if (avisDTO.getId() != null) {
            throw new BadRequestAlertException("A new avis cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AvisDTO result = avisService.save(avisDTO);
        return ResponseEntity.created(new URI("/api/avis/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /avis} : Updates an existing avis.
     *
     * @param avisDTO the avisDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated avisDTO,
     * or with status {@code 400 (Bad Request)} if the avisDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the avisDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/avis")
    public ResponseEntity<AvisDTO> updateAvis(@Valid @RequestBody AvisDTO avisDTO) throws URISyntaxException {
        log.debug("REST request to update Avis : {}", avisDTO);
        if (avisDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AvisDTO result = avisService.save(avisDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, avisDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /avis} : get all the avis.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of avis in body.
     */
    @GetMapping("/avis")
    public List<AvisDTO> getAllAvis() {
        log.debug("REST request to get all Avis");
        return avisService.findAll();
    }

    /**
     * {@code GET  /avis/:id} : get the "id" avis.
     *
     * @param id the id of the avisDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the avisDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/avis/{id}")
    public ResponseEntity<AvisDTO> getAvis(@PathVariable Long id) {
        log.debug("REST request to get Avis : {}", id);
        Optional<AvisDTO> avisDTO = avisService.findOne(id);
        return ResponseUtil.wrapOrNotFound(avisDTO);
    }

    /**
     * {@code DELETE  /avis/:id} : delete the "id" avis.
     *
     * @param id the id of the avisDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/avis/{id}")
    public ResponseEntity<Void> deleteAvis(@PathVariable Long id) {
        log.debug("REST request to delete Avis : {}", id);
        avisService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
