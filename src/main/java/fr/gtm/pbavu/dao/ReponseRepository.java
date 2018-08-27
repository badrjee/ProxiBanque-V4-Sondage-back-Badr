package fr.gtm.pbavu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.gtm.pbavu.domain.Reponse;

/**
 * L'interface ReposneRepository permet d'accorder une entité reponse à un JPA
 * repository
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */

public interface ReponseRepository extends JpaRepository<Reponse, Integer> {

	/**
	 * Requête permettant le nombre de réponse totale à un sondage
	 *
	 * @param id
	 * @return Integer nombre de réponses
	 */
	@Query(value = "SELECT COUNT(`nouveauClient`) FROM `reponse` WHERE `id_sondage`=?1 AND `nouveauClient` = 1 ", nativeQuery = true)
	Integer findNewClientRep(Integer id);

	/**
	 * Requête permettant la liste des réponses négatives à un sondage
	 *
	 * @param id
	 * @return
	 */
	@Query(value = " SELECT * FROM `reponse` WHERE `id_sondage`=?1 AND `statut` = 0 ", nativeQuery = true)
	List<Reponse> findRepoByNeg(Integer id);

	/**
	 * Requête permettant la liste des réponses positives à un sondage
	 *
	 * @param id
	 *            L'id du sondage dont on veut récupérer les réponses.
	 * @return List<Reponse> Retourne la liste de réponses du sondage d'id entré en
	 *         param.
	 */
	@Query(value = " SELECT * FROM `reponse` WHERE `id_sondage`=?1 AND `statut` = 1 ", nativeQuery = true)
	List<Reponse> findRepoByPos(Integer id);
}
