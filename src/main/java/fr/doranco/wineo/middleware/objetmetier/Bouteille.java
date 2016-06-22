package fr.doranco.wineo.middleware.objetmetier;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.rits.cloning.Cloner;

/**
 * Une bouteille
 * 
 * @author Snekkja JFDC 
 */
public class Bouteille implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	/** Référence unique */
	private String reference;

	/** Contenance exprimée en L */
	private Double contenance;

	/** Designation */
	private String designation;

	/** Année */
	private Integer annee;

	/** Récompenses */
	private Recompenses recompenses;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Double getContenance() {
		return contenance;
	}

	public void setContenance(Double contenance) {
		this.contenance = contenance;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public Recompenses getRecompenses() {
		return recompenses;
	}

	public void setRecompenses(Recompenses recompenses) {
		this.recompenses = recompenses;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(annee)
				.append(contenance)
				.append(designation)
				.append(recompenses)
				.append(reference)
				.build();
	}

	@Override
	public boolean equals(Object candidat) {
		
		if (candidat == null)
			return false;
		
		if (this == candidat)
			return true;
		
		if (!(candidat instanceof Bouteille))
			return false;
		
		Bouteille autre = (Bouteille) candidat;
		
		return new EqualsBuilder()
				.append(this.annee, autre.annee)
				.append(this.contenance, autre.contenance)
				.append(this.designation, autre.designation)
				.append(this.recompenses, autre.recompenses)
				.append(this.reference, autre.reference)
				.build();
	}

	@Override
	public Bouteille clone() {
		return Cloner.shared().deepClone(this); 
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("Reference", reference)
				.append("Contenance", contenance)
				.append("Designation", designation)
				.append("Année", annee)
				.append("Récompenses", recompenses)
				.build();
	}

}
