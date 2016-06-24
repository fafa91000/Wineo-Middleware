package fr.doranco.wineo.middleware.objetmetier.cave;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.rits.cloning.Cloner;

/**
 * Un entrepot
 * 
 * @author Snekkja JFDC
 */
public class Entrepot implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	/** Ensemble de caves uniques */
	private Set<Cave> caves;
	
	/** Capacité maximale */
	private Integer capaciteMaximale;
	
	public Set<Cave> getCaves() {
		return caves;
	}

	public void setCaves(Set<Cave> caves) {
		this.caves = caves;
	}

	public Integer getCapaciteMaximale() {
		return capaciteMaximale;
	}

	public void setCapaciteMaximale(Integer capaciteMaximale) {
		this.capaciteMaximale = capaciteMaximale;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.capaciteMaximale)
				.append(this.caves)
				.build();
	}

	@Override
	public boolean equals(Object candidat) {
		
		if (candidat == null)
			return false;
		if (candidat == this)
			return true;
		if (!(candidat instanceof Entrepot))
			return false;
		
		Entrepot autre = (Entrepot) candidat;
		
		return new EqualsBuilder()
				.append(this.capaciteMaximale, autre.capaciteMaximale)
				.append(this.caves, autre.caves)
				.build();
	}

	@Override
	public Entrepot clone() {
		return Cloner.shared().deepClone(this);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("Capacité maximale", this.capaciteMaximale)
				.append("Caves", this.caves)
				.build();
	}
	
}
