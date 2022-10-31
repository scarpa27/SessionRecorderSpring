delete from project_;
delete from session_;



insert into project_ (name)
values ('Project X'),
       ('Test zadatak'),
       ('Session rec123');

insert into session_ (project_id, sstart, send)
values (1, '2022-10-24 10.10.10', '2022-10-24 16.45.50'),
       (2, '2022-10-25 8.15.0', '2022-10-25 12.30.11'),
       (2, '2022-10-26 6.40.10', '2022-10-26 11.00.00'),
       (2, '2022-10-26 23.12.42', '2022-10-27 4.46.32'),
       (2, '2022-10-25 7.10.15', '2022-10-25 17.45.23'),
       (3, '2022-10-25 8.23.13', '2022-10-25 14.36.11'),
       (3, '2022-10-29 8.21.58', '2022-10-29 19.10.32'),
       (3, '2022-10-31 7.40.47', '2022-10-31 16.55.20');

CREATE SEQUENCE PROJECT_SEQUENCE_ID START WITH (select max(id) + 1 from project_);
CREATE SEQUENCE SESSION_SEQUENCE_ID START WITH (select max(id) + 1 from session_);
