package fr.gtm.pbavu.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.pbavu.dao.SondageRepository;
import fr.gtm.pbavu.domain.Sondage;

/**
 * Service permettant de traiter tout ce qui concerne les sondages (sondage en
 * cours, fermeture...)
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */
@Service
public class SondageService extends CRUDService<Sondage> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SondageService.class);

	@Autowired
	private SondageRepository repo;

	@Override
	public Sondage create(final Sondage sondage) {
		return this.repo.save(sondage);
	}

	/**
	 *
	 * cette methode permet de fermer un sondage ouvert
	 *
	 * @param id
	 *            l'id d'un sondage
	 * @param dateFermeture
	 *            date de fermeture d'un sondage
	 * @return false si il n'y a pas de sondage ouvert, true si il existe un sondage
	 *         ouvert
	 */
	public boolean fermetureSondage(final Integer id, final LocalDate dateFermeture) {
		boolean result = false;
		final Optional<Sondage> tempSondage;
		tempSondage = this.repo.findById(id);

		// si un sondage a été récupéré par le DAO
		if (tempSondage.isPresent()) {
			final Sondage actualSondage = tempSondage.get();

			SondageService.LOGGER.debug("j'ai récupéré le sondage actuel");
			SondageService.LOGGER.debug("DAte de début de sondage recupérer !" + actualSondage.getDateDebut());
			// verifier si le sondage est en cours
			// si le sondage est en cours ajouter dateFermeture et return true
			if (dateFermeture.isAfter(actualSondage.getDateDebut())
					&& dateFermeture.isBefore(actualSondage.getDateFin())) {
				actualSondage.setDateFermeture(dateFermeture);
				this.edit(actualSondage);
				result = true;
			}
		}

		// si le sondage est déjà fermé return false
		return result;
	}

	/**
	 * cette methode vérifie s'il existe sondage ouvert a la date actuel
	 *
	 * @param actualDate
	 *            la date actuel
	 * @return Sondage sondage en cours ou null
	 */
	public Sondage getActualSondage(final LocalDate actualDate) {
		Sondage result = null;
		// récupère l'ensemble des sondage dans une liste
		final List<Sondage> sondages = this.repo.findAll();
		for (final Sondage sondage : sondages) {
			// vérifie si la date saisie est comprise dans la période d'un des sondages
			if (actualDate.isAfter(sondage.getDateDebut()) == true
					&& actualDate.isBefore(sondage.getDateFin()) == true) {
				SondageService.LOGGER.debug("j'ai parcouru un sondage");
				result = sondage;
			}
		}
		return result;
	}

	/**
	 * Méthode permettant de calculer le nombre de jours entre la date du jour et la
	 * date de fin du sondage en cours.
	 *
	 * @return Integer le nombre de jours calculé.
	 */
	public Integer getNbJour() {
		SondageService.LOGGER.debug("Sondage Service bonjour je calcule le nbre de jours");
		final LocalDate dateDujour = LocalDate.now();
		Integer result = null;
		Sondage sondageCourant;

		sondageCourant = this.getActualSondage(dateDujour);

		final Period intervalPeriod = Period.between(dateDujour, sondageCourant.getDateFin());
		// récupère le nbre de jour de l'intervalle
		result = intervalPeriod.getDays();

		return result;
	}

	

}
