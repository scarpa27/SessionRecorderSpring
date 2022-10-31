package hr.tvz.cizmic.sessionrecorderspring.worksession.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "project_")
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Session> sessionList;

    public Project (ProjectCMD cmd) {
        this.name = cmd.getName();
    }

    public Project addSession(SessionCMD cmd) {
        if (this.sessionList == null)
            this.sessionList = new ArrayList<>();
        this.sessionList.add(new Session(this, cmd));

        return this;
    }

    public ProjectDTO dto() {
        return new ProjectDTO(
                this.id,
                this.name,
                (sessionList != null ?
                sessionList.stream().map(Session::dto).collect(Collectors.toList()) : new ArrayList<>()));

    }
}
