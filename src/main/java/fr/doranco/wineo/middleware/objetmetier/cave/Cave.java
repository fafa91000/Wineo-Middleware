package fr.doranco.wineo.middleware.objetmetier.cave;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.rits.cloning.Cloner;

import fr.doranco.wineo.middleware.objetmetier.Bouteille;

/**
 * Une cave.
 * 
 * @author Snekkja JFDC
 */
public class Cave implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	/** Dictionnaire des bouteilles */
	private Map<String, Bouteille> bouteilles;
	
	/** Capacité maximale */
	private Integer capaciteMaximale;

	/** Référence unique */
	private String reference;

	/** Nom du propriétaire */
	private String nomProprietaire;

	public Map<String, Bouteille> getBouteilles() {
		return bouteilles;
	}

	public void setBouteilles(Map<String, Bouteille> bouteilles) {
		this.bouteilles = bouteilles;
	}

	public Integer getCapaciteMaximale() {
		return capaciteMaximale;
	}

	public void setCapaciteMaximale(Integer capaciteMaximale) {
		this.capaciteMaximale = capaciteMaximale;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.bouteilles)
				.append(this.capaciteMaximale)
				.append(this.nomProprietaire)
				.append(this.reference)
				.build();
	}

	@Override
	public boolean equals(Object candidat) {
		
		if (candidat == null)
			return false;
		if (candidat == this)
			return true;
		if (!(candidat instanceof Cave))
			return false;
		
		Cave autre = (Cave) candidat;
		
		return new EqualsBuilder()
				.append(this.bouteilles, autre.bouteilles)
				.append(this.capaciteMaximale, autre.capaciteMaximale)
				.append(this.nomProprietaire, autre.nomProprietaire)
				.append(this.reference, autre.reference)
				.build();
	}

	@Override
	public Cave clone() {
		return Cloner.shared().deepClone(this);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("Référence", this.reference)
				.append("Nom du propriétaire", this.nomProprietaire)
				.append("Capacité maximale", this.capaciteMaximale)
				.append("Bouteilles", this.bouteilles)
				.build();
	}
	
}
