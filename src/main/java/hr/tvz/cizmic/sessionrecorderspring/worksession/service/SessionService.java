package hr.tvz.cizmic.sessionrecorderspring.worksession.service;

import hr.tvz.cizmic.sessionrecorderspring.worksession.model.SessionCMD;
import hr.tvz.cizmic.sessionrecorderspring.worksession.model.SessionDTO;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    List<SessionDTO> findAll();

    Optional<SessionDTO> save(SessionCMD s);
}
