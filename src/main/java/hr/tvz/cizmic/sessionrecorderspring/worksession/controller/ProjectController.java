package hr.tvz.cizmic.sessionrecorderspring.worksession.controller;

import hr.tvz.cizmic.sessionrecorderspring.worksession.model.ProjectCMD;
import hr.tvz.cizmic.sessionrecorderspring.worksession.model.ProjectDTO;
import hr.tvz.cizmic.sessionrecorderspring.worksession.model.SessionCMD;
import hr.tvz.cizmic.sessionrecorderspring.worksession.model.SessionDTO;
import hr.tvz.cizmic.sessionrecorderspring.worksession.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
@RequestMapping("api/project")
public class ProjectController {

    private final ProjectService service;

    @Autowired
    public ProjectController(@Qualifier("project_service") ProjectService ps) {
        this.service = ps;
    }

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return service.findAll();
    }

    @GetMapping(value = "/{id:\\d+}")
    public ResponseEntity<ProjectDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(p -> ResponseEntity.ok().body(p))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> save(@Valid @RequestBody final ProjectCMD cmd) {
        return service.save(cmd)
                .map(p -> ResponseEntity.status(HttpStatus.CREATED).body(p))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping(value = "/{id:\\d+}")
    public ResponseEntity<ProjectDTO> saveSession(@PathVariable Long id, @Valid @RequestBody final SessionCMD sessionCMD) {
        return service.addSession(id, sessionCMD)
                .map(p -> ResponseEntity.ok().body(p))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id:\\d+}")
    public ResponseEntity<SessionDTO> update(@PathVariable Long id, @Valid @RequestBody final SessionCMD cmd) {
        return service.editSession(id, cmd)
                .map(h -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(h))
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        service.deleteSession(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
