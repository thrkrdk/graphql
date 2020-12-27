INSERT INTO user (id, first_name, last_name, email) VALUES
  (1,'Ali','veli','ali@veli.maria'),
  (2,'Abdul','Kadir','abdul@kadir.user'),
  (3,'Ayşe','Fatma','ayse@fatma.hayriye');


INSERT INTO role (id, name, user_id) VALUES
  (1,'USER',1),
  (2,'ADMIN',1),
  (3,'TESTER',1),
  (4,'DBA',2),
  (5,'DBA',1),
  (6,'APP_ADMIN',2),
  (7,'ADMIN',2),
  (8,'RELEASE',3),
  (9,'DEVELOPER',3);
