create table usuario(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    correo_electronico varchar(100) not null unique,
    contrasena varchar(100) not null,
    perfiles varchar(100) not null,

    primary key(id)

);