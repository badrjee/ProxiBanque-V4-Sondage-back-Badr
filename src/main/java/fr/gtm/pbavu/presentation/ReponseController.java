package fr.gtm.pbavu.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.pbavu.domain.Reponse;
import fr.gtm.pbavu.service.ReponseService;

/**
 * Classe représentant le web-service de la Classe Reponse.
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reponse")
public class ReponseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ReponseService reponseService;

	/**
	 * Crée une réponse négative lors de la soumission du formulaire "Commentaire"
	 *
	 * @param commentaire
	 *            Commentaire renseigné par le client (peut être null).
	 * @param id
	 *            Identifiant du sondage en cours.
	 * @return Reponse Créé une nouvelle réponse.
	 */
	@PostMapping("/negative/{id}")
	@ResponseBody
	public String createNegativeReponse(@RequestBody final Reponse reponse, @PathVariable final Integer id) {
		ReponseController.LOGGER.debug("Webservice Reponse Bonjour");

		this.reponseService.createReponseNegative(reponse, id);
		return "Reponse négative créée avec succès";
	}

}