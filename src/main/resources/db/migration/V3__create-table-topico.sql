create table topico(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null unique,
    fecha_creacion datetime not null,
    status tinyint not null,
    autor varchar(100) not null,
    curso varchar(100) not null,
    respuesta varchar(100) not null,

    primary key(id)

);