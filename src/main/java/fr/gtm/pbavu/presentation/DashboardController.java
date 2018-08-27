package fr.gtm.pbavu.presentation;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gtm.pbavu.domain.Sondage;
import fr.gtm.pbavu.service.ClientService;
import fr.gtm.pbavu.service.ReponseService;
import fr.gtm.pbavu.service.SondageService;

/**
 * Ce controller comprend toutes méthodes permettant d'afficher les JSP
 * correspondants au tableau de bord de gestion des sondages par les employés de
 * la banque.
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */
@Controller
public class DashboardController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

	@Autowired
	private ClientService clientService;

	@Autowired
	private ReponseService repService;

	@Autowired
	private SondageService sondService;

	/**
	 * Creation d'un post Mapping permettant la creation d'un sondage avec une date
	 * de début et de fin
	 *
	 * @param dateDebut
	 *            Date de début du sondage à créer.
	 * @param dateFin
	 *            Date de fin du sondage à créer.
	 * @return redirection redirect vers vue erreur ou sur l'index.
	 */
	@PostMapping({ "/index", "/" })
	public String creatSondage(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate dateDebut,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate dateFin) {
		String result = null;
		final String pageErreur = "redirect:/erreurcreatesondage.html";
		if (this.sondService.getActualSondage(dateDebut) != null) {
			result = pageErreur;
		} else {
			if (this.sondService.getActualSondage(dateFin) != null) {
				result = pageErreur;
			} else {
				final Sondage sondage = new Sondage();
				sondage.setDateDebut(dateDebut);
				sondage.setDateFin(dateFin);
				this.sondService.create(sondage);
				result = "redirect:/index.html";
			}
		}
		return result;
	}

	/**
	 * Permet d'afficher la JSP qui affiche les détails d'un sondage
	 *
	 * @param idSondage
	 *            id du sondage à afficher.
	 * @param model
	 * @return redirection redirect vers la vue détail du sondage.
	 */
	@RequestMapping({ "/detail" })
	public String detail(@RequestParam("id") final Integer idSondage, final Model model) {
		// avis positif
		final Integer aviOk = this.repService.reponsePositif(idSondage);
		// avis negatif
		final Integer aviNot = this.repService.reponseNegatif(idSondage);
		// nbre de nouveau client
		final Integer nbClient = this.repService.nouvClientReponse(idSondage);
		model.addAttribute("idSond", idSondage);
		model.addAttribute("aviOk", aviOk);
		model.addAttribute("aviNot", aviNot);
		model.addAttribute("nbClient", nbClient);
		return "detail";
	}

	/**
	 * Redirection vers vue erreur.
	 *
	 * @return vueErreurCreateSondage Revoi vers la jsp correspondante.
	 */
	@RequestMapping("/erreurcreatesondage")
	public String erreurCreateSondage() {
		return "erreurcreatesondage";
	}

	/**
	 * Redirection vers vue erreur.
	 *
	 * @return vueErreurDate Revoi vers la jsp correspondante.
	 */
	@RequestMapping("/erreurdate")
	public String erreurDate() {
		return "erreurdate";
	}

	/**
	 * Permet l'affichage de la page de fermeture d'un sondage
	 *
	 * @param id
	 *            id du sondage à fermer.
	 */
	@RequestMapping("/fermeture")
	public String fermeture(@RequestParam("id") final Integer idSondage, @RequestParam("isOpen") final Boolean isOpen,
			final Model model) {

		model.addAttribute("id", idSondage);
		model.addAttribute("isOpen", isOpen);
		return "fermeture";
	}

	/**
	 * Permet de récupérer la requête post de l'ajout d'une date de fermeture par
	 * l'utilisateur
	 *
	 * @param dateFermeture
	 *            date de fermeture du sondage.
	 * @param idSondage
	 *            id du sondage à cloturer.
	 * @return redirection redirect vers vue erreur ou index.
	 */
	@PostMapping("/fermeture")
	public String fermeturePost(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate dateFermeture,
			@RequestParam("id") final Integer idSondage, final Model model) {
		final StringBuilder view = new StringBuilder();

		final boolean isOpen = this.sondService.fermetureSondage(idSondage, dateFermeture);
		if (isOpen) {
			view.append("redirect:/index.html");
		} else {
			view.append("redirect:/erreurdate.html");
		}

		final String result = view.toString();
		return result;
	}

	/**
	 * permet l'affichage de la JSP index (dashboard gestion sondage) sur l'url / ou
	 * /index
	 *
	 * @return la page Index.html
	 */
	@RequestMapping({ "/index", "/" })
	public String index(final Model model) {

		final List<Sondage> sondages = this.sondService.getList();

		DashboardController.LOGGER.debug("CONTROL j'ai mis les sondages dans le model");
		model.addAttribute("sondages", sondages);

		return "index";
	}

}
