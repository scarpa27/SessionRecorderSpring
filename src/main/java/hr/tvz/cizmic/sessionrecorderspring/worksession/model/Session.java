package hr.tvz.cizmic.sessionrecorderspring.worksession.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity @Table(name = "session_")
@Getter @Setter @NoArgsConstructor
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @Column(name = "sstart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Column(name = "send")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    public Session(Project p, SessionCMD cmd) {
        this.project = p;
        this.start = new Date(cmd.getStart());
        this.end = new Date(cmd.getEnd());
    }

    public Session edit(SessionCMD cmd, Project p) {
        this.start = new Date(cmd.getStart());
        this.end = new Date(cmd.getEnd());
        this.project = p;
        return this;
    }

    public SessionDTO dto() {
        return new SessionDTO(
                this.id,
                this.project.getName(),
                this.start.getTime(),
                this.end.getTime()
        );
    }
}
