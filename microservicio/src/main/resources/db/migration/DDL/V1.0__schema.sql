create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);


create table parametro(
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 valor varchar(100) not null,
 tipo_parametro varchar(50) not null,
 primary key (id)
);

create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 email varchar(100) not null,
 telefono varchar(10) not null,
 ciudad_id int(11) not null,
 fechaCreacion datetime not null,
 primary key(id),
 foreign key(ciudad_id) references parametro(id)
);

create table cita (
 id int(11) not null auto_increment,
 servicio_id int(11) not null,
 fecha_hora datetime not null,
 sede_id int(11) not null,
 cliente_id int(11) not null,
 primary key(id),
 foreign key(sede_id) references parametro(id),
 foreign key(cliente_id) references cliente(id)
)