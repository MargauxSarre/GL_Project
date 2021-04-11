package fr.polytech.info4.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link fr.polytech.info4.domain.Restaurant} entity.
 */
public class RestaurantDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String nom;

    @NotNull
    @Size(min = 10, max = 200)
    private String adresse;


    private Long compteId;
    private Set<TypeCommerceDTO> typeCommerces = new HashSet<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getCompteId() {
        return compteId;
    }

    public void setCompteId(Long compteId) {
        this.compteId = compteId;
    }

    public Set<TypeCommerceDTO> getTypeCommerces() {
        return typeCommerces;
    }

    public void setTypeCommerces(Set<TypeCommerceDTO> typeCommerces) {
        this.typeCommerces = typeCommerces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestaurantDTO)) {
            return false;
        }

        return id != null && id.equals(((RestaurantDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RestaurantDTO{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", compteId=" + getCompteId() +
            ", typeCommerces='" + getTypeCommerces() + "'" +
            "}";
    }
}
