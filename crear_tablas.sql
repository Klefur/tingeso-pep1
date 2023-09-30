create table if not exists tipo_colegio(
	id serial primary key,
	nombre varchar(100) not null,
	max_cuotas int not null,
	dcto int not null
);

create table if not exists precio(
	id serial primary key,
	nombre varchar(100) not null,
	precio int not null
);

create table if not exists usuario(
	id serial primary key,
	nombres varchar(100) not null,
	apellidos varchar(100) not null,
	rut varchar(50) not null,
	fecha_nacimiento date not null,
	grad_year smallint not null,
	nombre_colegio varchar(100) not null,
	id_tipo_colegio int not null,
	constraint fk_tipo_colegio
		foreign key(id_tipo_colegio)
			references tipo_colegio(id)
);

create table if not exists dcto_egreso(
	id serial primary key,
	dcto int not null,
	tiempo_egreso int not null
);

create table if not exists dcto_cuota(
	id serial primary key,
	dcto int not null,
	puntaje_prom int not null
);

create table if not exists pago(
	id serial primary key,
	total int not null,
	nro_cuota int not null,
	fecha_plazo date not null,
	atrasado bool default false,
	pagado bool default false,
	dcto_aplicable int default 0,
	id_usuario int not null,
	constraint fk_usuario
		foreign key(id_usuario)
			references usuario(id)
);

create table if not exists nota(
	id serial primary key,
	nota int not null,
	fecha date not null,
	id_usuario int not null,
	constraint fk_usuario
		foreign key(id_usuario)
			references usuario(id)
);

create table if not exists interes(
	id serial primary key,
	meses_atraso int not null,
	interes smallint not null
);