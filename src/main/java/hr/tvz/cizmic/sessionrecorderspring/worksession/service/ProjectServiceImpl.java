package hr.tvz.cizmic.sessionrecorderspring.worksession.service;

import hr.tvz.cizmic.sessionrecorderspring.worksession.model.*;
import hr.tvz.cizmic.sessionrecorderspring.worksession.repository.ProjectJpaRepo;
import hr.tvz.cizmic.sessionrecorderspring.worksession.repository.SessionJpaRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Qualifier("project_service")
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectJpaRepo pRepo;
    private final SessionJpaRepo sRepo;

    @Override
    public List<ProjectDTO> findAll() {
        return pRepo.findAll().stream().map(Project::dto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProjectDTO> findById(Long id) {
        return pRepo.findById(id).map(Project::dto);
    }

    @Override
    public Optional<ProjectDTO> addSession(Long id, SessionCMD cmd) {
        return Optional.of(pRepo.save(pRepo.findById(id).orElse(new Project()).addSession(cmd)).dto());
    }


    @Override
    public Optional<ProjectDTO> save(ProjectCMD cmd) {
        return Optional.of(pRepo.save(new Project(cmd)).dto());
    }

    @Override
    public Optional<ProjectDTO> update(Long id, ProjectCMD cmd) {
        return Optional.empty();
    }

    @Override
    public Optional<SessionDTO> editSession(Long id, SessionCMD cmd) {
        return Optional.of(sRepo.save(sRepo.findById(id).orElse(new Session()).edit(cmd, pRepo.getById(cmd.getProject_id()))).dto());
    }

    @Override
    public void deleteSession(Long id) {
        sRepo.deleteById(id);
    }
}
