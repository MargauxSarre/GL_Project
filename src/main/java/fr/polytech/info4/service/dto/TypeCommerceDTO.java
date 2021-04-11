package fr.polytech.info4.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link fr.polytech.info4.domain.TypeCommerce} entity.
 */
public class TypeCommerceDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String nom;

    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TypeCommerceDTO)) {
            return false;
        }

        return id != null && id.equals(((TypeCommerceDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TypeCommerceDTO{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            "}";
    }
}
