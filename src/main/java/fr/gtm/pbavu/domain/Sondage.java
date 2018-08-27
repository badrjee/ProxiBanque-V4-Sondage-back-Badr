package fr.gtm.pbavu.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe représentant les sondages lancés par la banque sur une durée
 * déterminée
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */

@Entity
public class Sondage implements fr.gtm.pbavu.domain.Entity {

	/**
	 * Date de début du sondage
	 */
	private LocalDate dateDebut;

	/**
	 * Date saisie par l'utilisateur pour fermer le sondage
	 */
	private LocalDate dateFermeture;

	/**
	 * Date programmée de fermeture
	 */
	private LocalDate dateFin;

	/**
	 * Identifiant du sondage créé par la banque
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 *
	 * @return date de début du Sondage
	 */
	public LocalDate getDateDebut() {
		return this.dateDebut;
	}

	/**
	 *
	 * @return date fermetuer du sondage
	 */
	public LocalDate getDateFermeture() {
		return this.dateFermeture;
	}

	/**
	 *
	 * @return date fin du sondage
	 */
	public LocalDate getDateFin() {
		return this.dateFin;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 *
	 * @param dateDebut
	 *            debut du sondage
	 */
	public void setDateDebut(final LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 *
	 * @param dateFermeture
	 *            date fermeture du sondage
	 */
	public void setDateFermeture(final LocalDate dateFermeture) {
		this.dateFermeture = dateFermeture;
	}

	/**
	 *
	 * @param dateFin
	 *            date fin du sondage
	 */
	public void setDateFin(final LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

}
