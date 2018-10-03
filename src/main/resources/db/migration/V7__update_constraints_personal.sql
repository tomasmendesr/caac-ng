USE PICS
GO

IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[caac].[FK_PERSONAL_PROFESION]') AND parent_object_id = OBJECT_ID(N'[caac].[PERSONAL]'))
ALTER TABLE [caac].[PERSONAL] DROP CONSTRAINT [FK_PERSONAL_PROFESION]
GO

alter table caac.personal
drop column idprofesion;

alter table caac.personal
add idprofesion int null;


ALTER TABLE [caac].[PERSONAL]  WITH CHECK ADD  CONSTRAINT [FK_PERSONAL_PROFESION] FOREIGN KEY([idprofesion])
REFERENCES [commons_models].[PROFESION] ([prof_id])
GO

ALTER TABLE [caac].[PERSONAL] CHECK CONSTRAINT [FK_PERSONAL_PROFESION]
GO