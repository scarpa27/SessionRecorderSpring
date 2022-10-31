drop table if exists project_;
drop table if exists session_;

CREATE TABLE if not exists project_
(
    id          INTEGER         AUTO_INCREMENT,
    name        VARCHAR(100)    NOT NULL,
    CONSTRAINT  pk_project_     PRIMARY KEY (id)
);


CREATE TABLE if not exists session_
(
    id          INTEGER      AUTO_INCREMENT,
    project_id  INTEGER      NOT NULL,
    sstart      TIMESTAMP,
    send        TIMESTAMP,
    CONSTRAINT  pk_session_  PRIMARY KEY (id)
);

ALTER TABLE session_
    ADD FOREIGN KEY (project_id) REFERENCES project_ (id) ON DELETE NO ACTION ON UPDATE NO ACTION;
