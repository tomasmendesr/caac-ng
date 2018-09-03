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
insert into caac.alimentacion (clasificacion, descripcion) values ('Fuera de Sede', 'Viandas (Ollas populares, Acompa�amiento en calle, etc.)');
insert into caac.alimentacion (clasificacion, descripcion) values ('Fuera de Sede', 'Bolsones');
insert into caac.alimentacion (clasificacion, descripcion) values ('Fuera de Sede', 'Otro');

insert into caac.clasificacion_registros (descripcion) values ('Si, inform�tico');
insert into caac.clasificacion_registros (descripcion) values ('Si, en papel');
insert into caac.clasificacion_registros (descripcion) values ('No');

insert into caac.recursos (detalle) values ('Medicamentos');
insert into caac.recursos (detalle) values ('Anticonceptivos / Preservativos');
insert into caac.recursos (detalle) values ('�tiles escolares');
insert into caac.recursos (detalle) values ('Gastos de transporte');
insert into caac.recursos (detalle) values ('Ropa');
insert into caac.recursos (detalle) values ('Material de construcci�n');
insert into caac.recursos (detalle) values ('Elementos de higiene personal');

insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Centro Barrial','Dispositivo de d�a que brinda diversas actividades y espacios de asistencia integral que no cuenta con equipo profesional interdisciplinario (segun la ley de salud mental)');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Centro de Dia','Dispositivo de dia que brinda diversas actividades y espacios de asistencia integral. Cuenta con equipo profesional interdisciplinario (segun la ley de salud mental)');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Centro de Medio Camino','dispositivo residencial cuyo objetivo central es abordar el proceso de reinscripci�n social luego de un recorrido terap�utico a tales fines');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Centro Barrial con posibilidad de alojamiento','Dispositivo de dia que brinda diversas actividades y espacios de asistencia integral que no cuenta con equipo profesional interdisciplinario y ofrece la posibilidad de alojamiento (segun la ley de salud mental)');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Centro de Dia con posibilidad de alojamiento','Dispositivo de dia que brinda diversas actividades y espacios de asistencia integral que cuenta con equipo profesional interdisciplinario y ofrece la posibilidad de alojamiento (segun la ley de salud mental)');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Asistencia domiciliaria','Asistencia domiciliaria');
insert into caac.alternativas_asistenciales (nombre,descripcion) values ('Otro','Otro');


insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento/Visita','Establecimiento de Salud','En Internaci�n');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento/Visita','Establecimiento de Salud','En Consultorios Externos');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento/Visita','Establecimiento de Salud','En Emergencias');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento/Visita','Establecimiento de Salud','Desintoxicaci�n e internaci�n por consumo de sustancias');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gesti�n','Establecimiento de Salud','Gestion de turnos');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gesti�n','Establecimiento de Salud','Gestion de tr�mites para medicaci�n');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gesti�n','Establecimiento de Salud','Gestion de servicios (ej. sillas de ruedas, pr�tesis, anteojos, etc.)');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento/Visita','Comunidad Terap�utica/Centro Especializado','Acompa�amiento en centros de tratamiento especializado');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gesti�n','Comunidad Terap�utica/Centro Especializado','Gestion de ingreso/asistencia en centros de tratamiento especializado sin subsidio de Sedronar');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gesti�n','Comunidad Terap�utica/Centro Especializado','Gestion de ingreso/asistencia en centros de tratamiento especializado subsidiado por Sedronar');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gesti�n','Patrocinio Legal','En Sede');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Gesti�n','Patrocinio Legal','Fuera de Sede');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Penales o Comisar�as','Acompa�amiento en comisar�as');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Penales o Comisar�as','Acompa�amiento en penales');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Actividades','Penales o Comisar�as','Talleres/Charlas');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Actividades','Penales o Comisar�as','Actividades productivas');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Actividades','Penales o Comisar�as','Capacitaci�n');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Profesional de Salud','Terapia individual');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Profesional de Salud','Terapia familiar');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Profesional de Salud','Reunion multifamiliar');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Profesional de Salud','Informe social');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Profesional de Salud','Orientaci�n vocacional');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Profesional de Salud','Evaluaci�n diagn�stica psicol�gica/psiqui�trica');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Profesional de Salud','Control m�dico cl�nico');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Profesional de Salud','Seguimiento farmacol�gico');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Profesional de Salud','Grupos terap�uticos para asistidos');

insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Trayectorias Educativas','Acompa�amiento en escuela');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Trayectorias Educativas','Actividades de prevenci�n (talleres/charlas/grupos)');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Trayectorias Educativas','Apoyo escolar/alfabetizaci�n');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Trayectorias Educativas','Programa para la inclusi�n educativa (fines, progresar, etc.)');
insert into caac.acompaniamiento (acomp_tipo,acomp_establecimiento,acomp_detalle) values ('Acompa�amiento','Trayectorias Educativas','Escuela en sede');

insert into caac.clasificacion_frecuencia (descripcion) values ('Mas de una vez por semana');
insert into caac.clasificacion_frecuencia (descripcion) values ('Una vez por semana');
insert into caac.clasificacion_frecuencia (descripcion) values ('Una a tres veces por semana');
insert into caac.clasificacion_frecuencia (descripcion) values ('Menos de una por mes');

insert into caac.tramites (descripcion) values ('DNI');
insert into caac.tramites (descripcion) values ('Subsidios');
insert into caac.tramites (descripcion) values ('Becas');
insert into caac.tramites (descripcion) values ('Certificado de discapacidad');
insert into caac.tramites (descripcion) values ('Inserci�n laboral');
insert into caac.tramites (descripcion) values ('Servicios previsionales (ANSES/CUIL)');
insert into caac.tramites (descripcion) values ('Gestiones para la inclusi�n educativa');
insert into caac.tramites (descripcion) values ('Otro');