INSERT INTO USERS (id, login, password) VALUES (0, 'admin', 'admin');
INSERT INTO USERS (id, login, password) VALUES (1, 'user', 'user');

INSERT INTO ROLES (id, role, user_id) values (0, 'ADMIN', 0), (1, 'USER', 0);
INSERT INTO ROLES (id, role, user_id) values (2, 'USER', 1);