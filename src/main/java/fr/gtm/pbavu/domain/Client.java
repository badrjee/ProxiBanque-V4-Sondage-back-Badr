package fr.gtm.pbavu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe représentant le Client de la banque (détenteur d'un Compte client).
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */
@Entity
public class Client implements fr.gtm.pbavu.domain.Entity {

	/**
	 * l'id représente l'identifaint unique utiliser dans la base de donnée; il est
	 * generer par la base de donnée lors de la création d'un nouveau Client
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * L'email designe email du Client
	 */
	@Column(nullable = true)
	private String mail;

	/**
	 * nom du client
	 */
	@Column
	private String nom;

	/**
	 * Prénom du client
	 */
	@Column(nullable = true)
	private String numero;

	/**
	 * numero designe le numéro d'identifacation unique d'un client
	 */
	@Column
	private String prenom;

	/**
	 * telephone designe le numéro de téleéphonz du client
	 */
	@Column(nullable = true)
	private String telephone;

	/**
	 * Constructeur par défaut
	 */
	public Client() {
		// Constructeur par defaut
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 *
	 * @return le mail du client
	 */
	public String getMail() {
		return this.mail;
	}

	/**
	 *
	 * @return le nom du client
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 *
	 * @return le numero d'identification du client
	 */
	public String getNumero() {
		return this.numero;
	}

	/**
	 *
	 * @return prénom du client
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 *
	 * @return téléphone du client
	 */
	public String getTelephone() {
		return this.telephone;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @param mail
	 *            l'adresse mail du client
	 */
	public void setMail(final String mail) {
		this.mail = mail;
	}

	/**
	 *
	 * @param nom
	 *            nom de client
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 *
	 * @param numero
	 *            numéro d'authentification du client
	 */
	public void setNumero(final String numero) {
		this.numero = numero;
	}

	/**
	 *
	 * @param prenom
	 *            prénom du client
	 */
	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	/**
	 *
	 * @param telephone
	 *            téléphone de client
	 */
	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}

}
