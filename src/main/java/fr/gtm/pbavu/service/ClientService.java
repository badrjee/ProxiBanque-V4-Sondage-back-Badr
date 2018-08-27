package fr.gtm.pbavu.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.pbavu.dao.ClientRepository;
import fr.gtm.pbavu.domain.Client;
import fr.gtm.pbavu.domain.Reponse;

/**
 * Classe représentant le Client service.
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */

@Service
public class ClientService extends CRUDService<Client> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientRepository repo;
	@Autowired
	private ReponseService repservice;

	@Autowired
	private SondageService sonService;

	/**
	 * Méthode permettant de créer un nouveau client et d'enregistrer une réponse au
	 * sondage.
	 *
	 * @param client
	 *            Infos client entrée front.
	 * @return client Retourne le client persisté en base de donnée pour passer
	 *         l'id.
	 */
	public Client createClientRep(final Client client) {

		Client result = null;
		final Reponse reponsePositive = new Reponse();
		final LocalDate actualDate = LocalDate.now();
		// sauvegardé le client
		this.repo.save(client);
		result = this.repo.findByNomAndPrenom(client.getNom(), client.getPrenom());
		// creer une reponse positive avec ce client
		reponsePositive.setClient(result);
		reponsePositive.setStatut(true);
		reponsePositive.setNouveauClient(true);
		reponsePositive.setSondage(this.sonService.getActualSondage(actualDate));
		ClientService.LOGGER.debug("statut nouveau client : " + reponsePositive.getNouveauClient());
		// persister la reponse
		this.repservice.create(reponsePositive);
		ClientService.LOGGER.debug("réponse enregistrée : " + reponsePositive);

		return result;
	}

	/**
	 * Vérifier numero de compte et creer une reponse avec le client récupéré du DAO
	 * si ok sinon retourne false
	 *
	 * @param numero
	 * @return
	 */
	public Client verfierNumero(final String numero) {

		Client existClient = null;
		existClient = this.repo.findByNumero(numero);

		ClientService.LOGGER.debug("Numéro Client trouver! ");

		if (existClient != null) {

			// créer une réponse
			final Reponse reponse = new Reponse();
			reponse.setStatut(true);
			// lui attribuer un client
			reponse.setClient(existClient);
			final LocalDate actualDate = LocalDate.now();
			reponse.setSondage(this.sonService.getActualSondage(actualDate));
			ClientService.LOGGER.debug("JE SUIS PASSER ICI !");
			this.repservice.create(reponse);
		}

		return existClient;
	}

}
