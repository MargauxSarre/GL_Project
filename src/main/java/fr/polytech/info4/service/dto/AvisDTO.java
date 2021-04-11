package fr.polytech.info4.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link fr.polytech.info4.domain.Avis} entity.
 */
public class AvisDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer note;

    @Size(max = 1000)
    private String description;


    private Long courseId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AvisDTO)) {
            return false;
        }

        return id != null && id.equals(((AvisDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AvisDTO{" +
            "id=" + getId() +
            ", note=" + getNote() +
            ", description='" + getDescription() + "'" +
            ", courseId=" + getCourseId() +
            "}";
    }
}
