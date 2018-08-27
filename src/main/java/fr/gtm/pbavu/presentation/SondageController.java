package fr.gtm.pbavu.presentation;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.pbavu.domain.Sondage;
import fr.gtm.pbavu.service.SondageService;

/**
 * Classe représentant le web-service de la class Sondage.
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sondage")
public class SondageController {

	@Autowired
	private SondageService sondageService;

	/**
	 * Répond sur /api/sondage pour déterminer si un sondage est en cours ou non.
	 *
	 * @return la date de debut et fin du sondage en cours
	 */
	@GetMapping("")
	public Sondage checkSondage() {
		Sondage result = null;
		final LocalDate actualDate = LocalDate.now();
		final Sondage actualSondage = this.sondageService.getActualSondage(actualDate);
		if (actualSondage != null) {
			result = actualSondage;
		} else {
			result = null;
		}
		return result;
	}

	/**
	 * permet de répondre à la demande du nbre de jour avant la fermeture d'un
	 * sondage
	 *
	 * @return Un nombre de jour avant la fin du sondage en cours ou null
	 */
	@GetMapping("/nbjour")
	public Integer nbJourContact() {
		Integer result = null;
		result = this.sondageService.getNbJour();
		return result;
	}

}
