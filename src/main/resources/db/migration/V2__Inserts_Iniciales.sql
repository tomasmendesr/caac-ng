use PICS
go

delete from caac.ALIMENTACION
delete from caac.RECURSOS
delete from caac.CLASIFICACION_REGISTROS
delete from caac.CLASIFICACION_FRECUENCIA
delete from caac.ALTERNATIVAS_ASISTENCIALES
delete from caac.TRAMITES
delete from caac.ACOMPANIAMIENTO

DBCC CHECKIDENT ('caac.ALIMENTACION', RESEED, 1);  
DBCC CHECKIDENT ('caac.recursos', RESEED, 1);  
DBCC CHECKIDENT ('caac.clasificacion_frecuencia', RESEED, 1);  
DBCC CHECKIDENT ('caac.clasificacion_registros', RESEED, 1);  
DBCC CHECKIDENT ('caac.alternativas_asistenciales', RESEED, 1);  
DBCC CHECKIDENT ('caac.tramites', RESEED, 1);  
DBCC CHECKIDENT ('caac.acompaniamiento', RESEED, 1);  


insert into caac.alimentacion (clasificacion, descripcion) values ('En Sede', 'Desayuno');
insert into caac.alimentacion (clasificacion, descripcion) values ('En Sede', 'Almuerzo');
insert into caac.alimentacion (clasificacion, descripcion) values ('En Sede', 'Merienda');
insert into caac.alimentacion (clasificacion, descripcion) values ('En Sede', 'Cena');
insert into caac.alimentacion (clasificacion, descripcion) values ('En Sede', 'Otro');
insert into caac.alimentacion (clasificacion, descripcion) values ('Fuera de Sede', 'Viandas (Ollas populares, Acompañamiento en calle, etc.)');
insert into caac.alimentacion (clasificacion, descripcion) values ('Fuera de Sede', 'Bolsones');
insert into caac.alimentacion (clasificacion, descripcion) values ('Fuera de Sede', 'Otro');

insert into caac.clasificacion_registros (descripcion) values ('Si, informático');
insert into caac.clasificacion_registros (descripcion) values ('Si, en papel');
insert into caac.clasificacion_registros (descripcion) values ('No');

insert into caac.recursos (detalle) values ('Medicamentos');
insert into caac.recursos (detalle) values ('Anticonceptivos / Preservativos');
insert into caac.recursos (detalle) values ('Útiles escolares');
insert into caac.recursos (detalle) values ('Gastos de transporte');
insert into caac.recursos (detalle) values ('Ropa');
insert into caac.recursos (detalle) values ('Material de construcción');
insert into caac.recursos (detalle) values ('Elementos de higiene personal');

insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Centro Barrial','Dispositivo de día que brinda diversas actividades y espacios de asistencia integral que no cuenta con equipo profesional interdisciplinario (segun la ley de salud mental)');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Centro de Dia','Dispositivo de dia que brinda diversas actividades y espacios de asistencia integral. Cuenta con equipo profesional interdisciplinario (segun la ley de salud mental)');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Centro de Medio Camino','dispositivo residencial cuyo objetivo central es abordar el proceso de reinscripción social luego de un recorrido terapéutico a tales fines');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Centro Barrial con posibilidad de alojamiento','Dispositivo de dia que brinda diversas actividades y espacios de asistencia integral que no cuenta con equipo profesional interdisciplinario y ofrece la posibilidad de alojamiento (segun la ley de salud mental)');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Centro de Dia con posibilidad de alojamiento','Dispositivo de dia que brinda diversas actividades y espacios de asistencia integral que cuenta con equipo profesional interdisciplinario y ofrece la posibilidad de alojamiento (segun la ley de salud mental)');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Asistencia domiciliaria','Asistencia domiciliaria');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Otro','Otro');


insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento/Visita','Establecimiento de Salud','En Internación');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento/Visita','Establecimiento de Salud','En Consultorios Externos');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento/Visita','Establecimiento de Salud','En Emergencias');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento/Visita','Establecimiento de Salud','Desintoxicación e internación por consumo de sustancias');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gestión','Establecimiento de Salud','Gestion de turnos');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gestión','Establecimiento de Salud','Gestion de trámites para medicación');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gestión','Establecimiento de Salud','Gestion de servicios (ej. sillas de ruedas, prótesis, anteojos, etc.)');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento/Visita','Comunidad Terapéutica/Centro Especializado','Acompañamiento en centros de tratamiento especializado');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gestión','Comunidad Terapéutica/Centro Especializado','Gestion de ingreso/asistencia en centros de tratamiento especializado sin subsidio de Sedronar');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gestión','Comunidad Terapéutica/Centro Especializado','Gestion de ingreso/asistencia en centros de tratamiento especializado subsidiado por Sedronar');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gestión','Patrocinio Legal','En Sede');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gestión','Patrocinio Legal','Fuera de Sede');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Penales o Comisarías','Acompñamiento en comisarías');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Penales o Comisarías','Acompañamiento en penales');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Actividades','Penales o Comisarías','Talleres/Charlas');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Actividades','Penales o Comisarías','Actividades productivas');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Actividades','Penales o Comisarías','Capacitación');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Profesional de Salud','Terapia individual');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Profesional de Salud','Terapia familiar');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Profesional de Salud','Reunion multifamiliar');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Profesional de Salud','Informe social');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Profesional de Salud','Orientación vocacional');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Profesional de Salud','Evaluación diagnóstica psicológica/psiquiátrica');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Profesional de Salud','Control médico clínico');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Profesional de Salud','Seguimiento farmacológico');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Profesional de Salud','Grupos terapéuticos para asistidos');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Trayectorias Educativas','Acompañamiento en escuela');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Trayectorias Educativas','Actividades de prevención (talleres/charlas/grupos)');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Trayectorias Educativas','Apoyo escolar/alfabetización');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Trayectorias Educativas','Programa para la inclusión educativa (fines, progresar, etc.)');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompañamiento','Trayectorias Educativas','Escuela en sede');

insert into caac.clasificacion_frecuencia (descripcion) values ('Mas de una vez por semana');
insert into caac.clasificacion_frecuencia (descripcion) values ('Una vez por semana');
insert into caac.clasificacion_frecuencia (descripcion) values ('Una a tres veces por semana');
insert into caac.clasificacion_frecuencia (descripcion) values ('Menos de una por mes');

insert into caac.tramites (descripcion) values ('DNI');
insert into caac.tramites (descripcion) values ('Subsidios');
insert into caac.tramites (descripcion) values ('Becas');
insert into caac.tramites (descripcion) values ('Certificado de discapacidad');
insert into caac.tramites (descripcion) values ('Inserción laboral');
insert into caac.tramites (descripcion) values ('Servicios previsionales (ANSES/CUIL)');
insert into caac.tramites (descripcion) values ('Gestiones para la inclusión educativa');
insert into caac.tramites (descripcion) values ('Otro');