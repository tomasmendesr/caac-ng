use pics
go

alter table caac.h_mensual_personal
add [nombre] varchar(100),
[apellido] varchar(100),
[hs_semanales] int,
[rol] varchar(100),
[titulo] varchar(100),
[es_rentado] char(1);


alter table caac.hoja_personal
add [nombre] varchar(100),
[apellido] varchar(100),
[hs_semanales] int,
[rol] varchar(100),
[titulo] varchar(100),
[es_rentado] char(1);