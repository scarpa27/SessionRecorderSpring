package hr.tvz.cizmic.sessionrecorderspring.worksession.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectDTO {
    private Long id;
    private String name;
    private List<SessionDTO> sessionDTOList;
}
