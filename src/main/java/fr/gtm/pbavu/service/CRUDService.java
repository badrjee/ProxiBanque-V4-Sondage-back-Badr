package fr.gtm.pbavu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.pbavu.domain.Entity;

/**
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */
public abstract class CRUDService<ENTITY extends Entity> {

	/**
	 * Implémentation du repository générique qui sera injectée en valeur de "repo".
	 */
	@Autowired
	private JpaRepository<ENTITY, Integer> repo;

	/**
	 * Fonction permettant la création d'une entité.
	 *
	 * @param entity
	 *            les informations de l'entité à persister en base de données.
	 * @return ENTITY L'entité crée avec son identifiant auto-incrémenté.
	 */
	public ENTITY create(final ENTITY entity) {
		return this.save(entity);
	}

	/**
	 * Fonction permettant d'écraser les données de l'entité selectionnée en base de
	 * données.
	 *
	 * @param id
	 *            Identifiant de l'entité à supprimer.
	 */
	public void delete(final Integer id) {
		this.repo.deleteById(id);
	}

	/**
	 * Fonction permettant la modification de données sur l'entité définie en base
	 * de données.
	 *
	 * @param entity
	 *            Entité à modifier en base de données.
	 * @return ENTITY L'entité modifiée en base de données.
	 */
	public ENTITY edit(final ENTITY entity) {
		if (entity.getId() == null) {
			throw new IllegalArgumentException("Modification impossible sans identifiant valide");
		}
		return this.save(entity);
	}

	/**
	 * Fonction permettant de lister les entités présentes en base de données.
	 *
	 * @return List<ENTITY> Toutes les entités présentes en base de données.
	 */
	public List<ENTITY> getList() {
		return this.repo.findAll();
	}

	/**
	 * Fonction permettant d'accéder aux informations d'une entité trouvée par son
	 * id
	 *
	 * @param id
	 *            Identifiant de l'entité à retrouver.
	 * @return ENTITY Toutes les informations de l'entité.
	 */
	public ENTITY read(final Integer id) {
		ENTITY result = null;
		final Optional<ENTITY> wrapper = this.repo.findById(id);
		if (wrapper.isPresent()) {
			result = wrapper.get();
		}
		return result;
	}

	/**
	 * Factorisation de la fonction save qui sera utilisée par la création et la
	 * mise à jour.
	 *
	 * @param entity
	 *            Entité à persister pour la création ou mise à jour.
	 * @return ENTITY Sauvegarde de l'entité dans la base de donnée
	 */
	protected ENTITY save(final ENTITY entity) {
		return this.repo.save(entity);
	}
}
