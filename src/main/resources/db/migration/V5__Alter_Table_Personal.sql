use pics
go

alter table caac.personal
add nrodocumento int,
tipodocumento smallint;

alter table caac.personal
add constraint FK_TDOCUMENTO_PERSONAL FOREIGN KEY (tipodocumento)
references commons_models.tipodocumento (idtipodoc);