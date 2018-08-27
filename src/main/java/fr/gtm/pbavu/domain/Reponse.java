package fr.gtm.pbavu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Classe représentant la Réponse du client au Sondage que fait la banque.
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */

@Entity
public class Reponse implements fr.gtm.pbavu.domain.Entity {

	/**
	 * Objet de type Client represnte le Client qui répond au sondage
	 */
	@OneToOne
	@JoinColumn(name = "id_client", referencedColumnName = "id", nullable = true)
	private Client client;

	/**
	 * commentaire désigne un commantaire laisser par le client
	 */
	@Column(nullable = true)
	private String commentaire;

	/**
	 * l'id représente l'identifaint unique utiliser dans la base de donnée; il est
	 * génerer par la base de donnée lors de l'ajout d'une nouvelle réponse
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Le client qui à donnée son avis est-ce qu'il est nouveau ou pas
	 */
	@Column
	private Boolean nouveauClient;

	/**
	 * Objet sondage de type Sondage représente le sondge qui coorespond a la
	 * réponse du client
	 */
	@ManyToOne
	@JoinColumn(name = "id_sondage", referencedColumnName = "id")
	private Sondage sondage;

	/**
	 * sataut de la réponse si la réposne est positif (True) ou négatif (False)
	 */
	@Column
	private Boolean statut;

	/**
	 *
	 * @return un client de la classe Client
	 */
	public Client getClient() {
		return this.client;
	}

	/**
	 *
	 * @return le commentaire redigé par le client
	 */
	public String getCommentaire() {
		return this.commentaire;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 *
	 * @return un client qui a donnée son avis si il est nouveau
	 */
	public Boolean getNouveauClient() {
		return this.nouveauClient;
	}

	/**
	 *
	 * @return sondage effectuer par le client
	 */
	public Sondage getSondage() {
		return this.sondage;
	}

	/**
	 *
	 * @return status de la réponse si OK ou PAS OK
	 */
	public Boolean getStatut() {
		return this.statut;
	}

	/**
	 *
	 * @param client
	 *            client de la banque
	 */
	public void setClient(final Client client) {
		this.client = client;
	}

	/**
	 *
	 * @param commentaire
	 *            commentaire fait par le client s'il refuse le sondage
	 */
	public void setCommentaire(final String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @param nouveauClient
	 *            le client qui donne son avis s'il est nouveau
	 */
	public void setNouveauClient(final Boolean nouveauClient) {
		this.nouveauClient = nouveauClient;
	}

	/**
	 *
	 * @param sondage
	 *            sondagee effectuer par le client
	 */
	public void setSondage(final Sondage sondage) {
		this.sondage = sondage;
	}

	/**
	 *
	 * @param statut
	 *            statut de la reposne OK ou PAS-OK
	 */
	public void setStatut(final Boolean statut) {
		this.statut = statut;
	}

}
