package hr.tvz.cizmic.sessionrecorderspring.worksession.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class SessionCMD {
    @NotNull
    private Long project_id;

    @NotNull
    private Long start;

    @NotNull
    private Long end;
}

