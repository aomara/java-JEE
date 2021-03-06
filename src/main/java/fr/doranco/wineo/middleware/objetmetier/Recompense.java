package fr.doranco.wineo.middleware.objetmetier;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.rits.cloning.Cloner;

/**
 * Une récompense.
 * 
 * @author Snekkja JFDC
 */
public class Recompense implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	/** Nom */
	private String nom;
	
	/** Année */
	private Integer annee;
	
	/** Poids exprimé en décimal de 0 à 100 */
	private BigDecimal poids;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public BigDecimal getPoids() {
		return poids;
	}

	public void setPoids(BigDecimal poids) {
		this.poids = poids;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.annee)
				.append(this.nom)
				.append(this.poids)
				.build();
	}

	@Override
	public boolean equals(Object candidat) {
		
		if (candidat == null)
			return false;
		if (candidat == this)
			return true;
		if (!(candidat instanceof Recompense))
			return false;
		
		Recompense autre = (Recompense) candidat;
		
		return new EqualsBuilder()
				.append(this.annee, autre.annee)
				.append(this.nom, autre.nom)
				.append(this.poids, autre.poids)
				.build();
	}

	@Override
	public Recompense clone() {
		
		/*Recompense clone = new Recompense();
		
		clone.annee = this.annee;
		clone.nom = this.nom;
		clone.poids = new BigDecimal(poids.toPlainString());
		
		return clone;*/
		
		return new Cloner().deepClone(this);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("Nom", this.nom)
				.append("Année", this.annee)
				.append("Poids", this.poids)
				.build();
	}
	
}
