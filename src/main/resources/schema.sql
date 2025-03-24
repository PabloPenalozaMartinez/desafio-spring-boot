DROP TABLE usuarios;
DROP TABLE tareas;
DROP TABLE estados_tareas;

CREATE TABLE usuarios (
    id int PRIMARY KEY,
    nombre varchar(50) NOT NULL
);

CREATE TABLE estados_tareas (
    estados_tareas_id int PRIMARY KEY,
    descripcion varchar(100) NOT NULL
);

CREATE TABLE tareas (
    id int PRIMARY KEY,
    descripcion varchar(100) NOT NULL,
    fk_estados_tareas_id int NOT NULL
);

ALTER TABLE tareas
   ADD FOREIGN KEY (fk_estados_tareas_id) 
   REFERENCES estados_tareas(estados_tareas_id);