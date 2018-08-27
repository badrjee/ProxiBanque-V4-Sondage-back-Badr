package fr.gtm.pbavu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.pbavu.domain.Client;

/**
 * L'interface ClientRepository permet d'accorder une entité Client à un JPA
 * repository
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {


	/**
	 * Requête en base de données permettant de récupérer un client par ses nom et
	 * prénom.
	 *
	 * @param nom
	 *            nom du client à rechercher.
	 * @param prenom
	 *            prenom du client à rechercher.
	 * @return client revoi le client trouvé.
	 */
	Client findByNomAndPrenom(String nom, String prenom);

	/**
	 * Requête permettant de renvoyer un client existant grâce à son numero client
	 *
	 * @param numero
	 *            numéro client à trouver en base.
	 * @return client le client retrouvé par la requête.
	 */
	Client findByNumero(String numero);

}
