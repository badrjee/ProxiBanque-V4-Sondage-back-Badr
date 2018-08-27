package fr.gtm.pbavu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.pbavu.dao.ReponseRepository;
import fr.gtm.pbavu.domain.Reponse;
import fr.gtm.pbavu.domain.Sondage;

/**
 * Le ResponseService est le service apparenté l'entité Response
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */

@Service
public class ReponseService extends CRUDService<Reponse> {
	@Autowired
	private ReponseRepository repo;

	@Autowired
	private SondageService sondageService;

	/**
	 * Enregistre un Avis d'un Sondage dans une base de donnée
	 *
	 * @param reponse
	 *            réponse du client au sondage
	 * @param id
	 *            l'id de la réponse dans la base de donnée soit positif ou négatif
	 * @return sauvgarde d'une réponse
	 */
	public Reponse createReponseNegative(final Reponse reponse, final Integer id) {
		final Sondage sondage = this.sondageService.read(id);
		reponse.setSondage(sondage);
		reponse.setStatut(false);
		return this.save(reponse);
	}

	/**
	 * vérifie s'il y a un avis d'un nouveau client
	 *
	 * @param id
	 *            l'id de la réponse dans la base de donnée qu'un nouveau client a
	 *            laisser
	 * @return l'identifiant de la réponse
	 */
	public Integer nouvClientReponse(final Integer id) {
		final Integer result;
		result = this.repo.findNewClientRep(id);
		return result;
	}

	/**
	 * vérifie les réponses négatifs
	 *
	 * @param id
	 *            l'id de la réponse dans la base de donnée soit positif ou négatif
	 * @return l'identifiant de la réponse négatif
	 */
	public Integer reponseNegatif(final Integer id) {
		final Integer result = this.repo.findRepoByNeg(id).size();
		return result;
	}

	/**
	 * vérifie les réponses Positifs
	 *
	 * @param id
	 *            l'id de la réponse dans la base de donnée soit positif ou négatif
	 * @return l'identifiant de la réponse négatif
	 */
	public Integer reponsePositif(final Integer id) {
		final Integer result = this.repo.findRepoByPos(id).size();

		return result;
	}

}
