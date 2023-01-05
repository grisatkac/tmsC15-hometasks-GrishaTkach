use helpdesk;
INSERT INTO role(role)
VALUES
    ('USER'),
    ('ADMIN');

INSERT INTO user(first_name, last_name, email, password, can_do_job, role_id)
VALUES ('user', 'surname', 'user@gmail.com', 'pass', 1, (SELECT id from role where role = 'USER')),
       ('admin', 'surname', 'admin@gmail.com', 'pass', 1, (SELECT id from role where role = 'ADMIN'));

INSERT INTO ticket
(title, description, status)
VALUES ('title1', 'description1', 'COMPLETED'),
       ('title2', 'description2', 'COMPLETED'),
       ('title3', 'description3', 'PERFORMS'),
       ('title3', 'description3', 'COMPLETED');

INSERT INTO user_ticket
(user_id, ticket_id)
VALUES (1, 1),
       (NULL, 2),
       (2, 3),
       (2, 4);

use todo;
INSERT INTO task
(title, description, status)
VALUES ('title', 'description', 'DONE');

