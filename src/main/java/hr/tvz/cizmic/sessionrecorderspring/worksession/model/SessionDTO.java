package hr.tvz.cizmic.sessionrecorderspring.worksession.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SessionDTO {
    private Long id;
    private String project_name;
    private Long start;
    private Long end;
}
