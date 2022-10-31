package hr.tvz.cizmic.sessionrecorderspring.worksession.service;

import hr.tvz.cizmic.sessionrecorderspring.worksession.model.ProjectCMD;
import hr.tvz.cizmic.sessionrecorderspring.worksession.model.ProjectDTO;
import hr.tvz.cizmic.sessionrecorderspring.worksession.model.SessionCMD;
import hr.tvz.cizmic.sessionrecorderspring.worksession.model.SessionDTO;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectDTO> findAll();

    Optional<ProjectDTO> findById(Long id);

    Optional<ProjectDTO> save(ProjectCMD cmd);

    Optional <ProjectDTO> update (Long id, ProjectCMD cmd);

    Optional <SessionDTO> editSession (Long id, SessionCMD cmd);

    Optional <ProjectDTO> addSession(Long id, SessionCMD cmd);

    void deleteSession(Long id);
}
