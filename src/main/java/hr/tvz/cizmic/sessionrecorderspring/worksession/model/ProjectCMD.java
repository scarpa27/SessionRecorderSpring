package hr.tvz.cizmic.sessionrecorderspring.worksession.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProjectCMD {
    @NotBlank
    private String name;
}
