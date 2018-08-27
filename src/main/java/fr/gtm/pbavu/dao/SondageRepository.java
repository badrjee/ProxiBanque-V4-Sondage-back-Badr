package fr.gtm.pbavu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.pbavu.domain.Sondage;

/**
 * L'interface SondageRepository permet d'accorder une entité sondage à un JPA
 * repository
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */
public interface SondageRepository extends JpaRepository<Sondage, Integer> {

}
