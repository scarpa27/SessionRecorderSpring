package hr.tvz.cizmic.sessionrecorderspring.worksession.repository;


import hr.tvz.cizmic.sessionrecorderspring.worksession.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface ProjectJpaRepo extends JpaRepository<Project, Long> {
    Optional<Project> findById(Long id);
}
