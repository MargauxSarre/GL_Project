package fr.polytech.info4.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link fr.polytech.info4.domain.Commande} entity.
 */
public class CommandeDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 10, max = 200)
    private String adresse;


    private Long courseId;

    private Long compteId;

    private Long restaurantId;
    private Set<ProduitDTO> produits = new HashSet<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCompteId() {
        return compteId;
    }

    public void setCompteId(Long compteId) {
        this.compteId = compteId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Set<ProduitDTO> getProduits() {
        return produits;
    }

    public void setProduits(Set<ProduitDTO> produits) {
        this.produits = produits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommandeDTO)) {
            return false;
        }

        return id != null && id.equals(((CommandeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CommandeDTO{" +
            "id=" + getId() +
            ", adresse='" + getAdresse() + "'" +
            ", courseId=" + getCourseId() +
            ", compteId=" + getCompteId() +
            ", restaurantId=" + getRestaurantId() +
            ", produits='" + getProduits() + "'" +
            "}";
    }
}
