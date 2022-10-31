package hr.tvz.cizmic.sessionrecorderspring.worksession.repository;

import hr.tvz.cizmic.sessionrecorderspring.worksession.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SessionJpaRepo extends JpaRepository<Session, Long> {
}
