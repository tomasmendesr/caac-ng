USE PICS

GO

if object_id('caac.auditorias') is not null drop table caac.auditorias
if object_id('caac.pagos') is not null drop table caac.pagos
if object_id('caac.requisitos') is not null drop table caac.requisitos
if object_id('caac.vencimientos') is not null drop table caac.vencimientos
if object_id('caac.casas') is not null drop table caac.casas
if object_id('caac.logs') is not null drop table caac.logs
if object_id('caac.categorias') is not null drop table caac.categorias
if object_id('caac.schema_version') is not null drop table caac.schema_version
if object_id('caac.meses') is not null drop table caac.meses

if exists(select * from sys.schemas s where s.name='caac') drop schema caac

if not exists(select * from sys.schemas s where s.name='caac') exec('create schema caac')  

CREATE TABLE caac.ACOMPANIAMIENTO(
    idacompaniamiento        int             IDENTITY(1,1),
    acomp_tipo               varchar(50)     NULL,
    acomp_establecimiento    varchar(100)    NULL,
    acomp_detalle            varchar(100)    NULL,
    CONSTRAINT PK43 PRIMARY KEY NONCLUSTERED (idacompaniamiento)
)
go



IF OBJECT_ID('caac.ACOMPANIAMIENTO') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.ACOMPANIAMIENTO >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.ACOMPANIAMIENTO >>>'
go

/* 
 * TABLE: caac.ACTIVIDADES_INTERVENCIONES 
 */

CREATE TABLE caac.ACTIVIDADES_INTERVENCIONES(
    idactividad              int             NOT NULL,
    actividad_tipo           varchar(50)     NULL,
    actividad_descripcion    varchar(100)    NULL,
    CONSTRAINT PK50 PRIMARY KEY NONCLUSTERED (idactividad)
)
go



IF OBJECT_ID('caac.ACTIVIDADES_INTERVENCIONES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.ACTIVIDADES_INTERVENCIONES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.ACTIVIDADES_INTERVENCIONES >>>'
go

/* 
 * TABLE: caac.ALIMENTACION 
 */

CREATE TABLE caac.ALIMENTACION(
    id               int             IDENTITY(1,1),
    clasificacion    varchar(20)     NULL,
    descripcion      varchar(100)    NULL,
    CONSTRAINT PK25 PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('caac.ALIMENTACION') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.ALIMENTACION >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.ALIMENTACION >>>'
go

/* 
 * TABLE: caac.ALTERNATIVAS_ASISTENCIALES 
 */

CREATE TABLE caac.ALTERNATIVAS_ASISTENCIALES(
    id             int             IDENTITY(1,1),
    nombre         varchar(100)    NULL,
    descripcion    varchar(300)    NULL,
    CONSTRAINT PK13 PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('caac.ALTERNATIVAS_ASISTENCIALES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.ALTERNATIVAS_ASISTENCIALES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.ALTERNATIVAS_ASISTENCIALES >>>'
go

/* 
 * TABLE: caac.auditorias 
 */

CREATE TABLE caac.auditorias(
    id_audi     int              IDENTITY(2857,1),
    id          int              NOT NULL,
    anio        int              NOT NULL,
    naudi       int              NOT NULL,
    tipoaud     varchar(20)      NOT NULL,
    fechaudi    date             NOT NULL,
    prof        varchar(60)      NOT NULL,
    fechven     date             NOT NULL,
    canaten     int              NOT NULL,
    canasis     int              NOT NULL,
    obsaudi     varchar(3000)    NOT NULL,
    CONSTRAINT PK1_auditorias PRIMARY KEY NONCLUSTERED (id_audi)
)
go



IF OBJECT_ID('caac.auditorias') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.auditorias >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.auditorias >>>'
go

/* 
 * TABLE: caac.casas 
 */

CREATE TABLE caac.casas(
    id             int             IDENTITY(96,1),
    nomcaac        varchar(300)    NOT NULL,
    perjuridica    varchar(300)    NOT NULL,
    cuit           varchar(40)     NOT NULL,
    dir            varchar(300)    NOT NULL,
    nomrepre       varchar(300)    NOT NULL,
    tel            text            NOT NULL,
    mail           varchar(300)    NOT NULL,
    obser          text            NOT NULL,
    obseradm       text            NOT NULL,
    modal          varchar(60)     NOT NULL,
    cat            char(2)         NOT NULL,
    ncat           char(2)         NULL,
    fechaini       date            NOT NULL,
    fechacon       date            NOT NULL,
    expsed         varchar(30)     NOT NULL,
    req            varchar(60)     NOT NULL,
    idprov         int             NULL,
    idlocalidad    int             NULL,
    iddepto        int             NULL,
    activa         bit             CONSTRAINT [DF__casas__activa__6EC13C93] DEFAULT ((1)) NOT NULL,
    CONSTRAINT PK2_casas PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('caac.casas') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.casas >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.casas >>>'
go

/* 
 * TABLE: caac.categorias 
 */

CREATE TABLE caac.categorias(
    cat      char(2)    CONSTRAINT [DF__categorias__cat__11558062] DEFAULT ('A') NOT NULL,
    valor    int        NOT NULL,
    CONSTRAINT PK3_categorias PRIMARY KEY NONCLUSTERED (cat)
)
go



IF OBJECT_ID('caac.categorias') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.categorias >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.categorias >>>'
go

/* 
 * TABLE: caac.CLASIFICACION_FRECUENCIA 
 */

CREATE TABLE caac.CLASIFICACION_FRECUENCIA(
    id             int            IDENTITY(1,1),
    descripcion    varchar(50)    NULL,
    CONSTRAINT PK21 PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('caac.CLASIFICACION_FRECUENCIA') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.CLASIFICACION_FRECUENCIA >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.CLASIFICACION_FRECUENCIA >>>'
go

/* 
 * TABLE: caac.CLASIFICACION_REGISTROS 
 */

CREATE TABLE caac.CLASIFICACION_REGISTROS(
    idclasif_registros    int             IDENTITY(1,1),
    descripcion           varchar(200)    NULL,
    CONSTRAINT PK19 PRIMARY KEY NONCLUSTERED (idclasif_registros)
)
go



IF OBJECT_ID('caac.CLASIFICACION_REGISTROS') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.CLASIFICACION_REGISTROS >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.CLASIFICACION_REGISTROS >>>'
go

/* 
 * TABLE: caac.GESTIONES 
 */

CREATE TABLE caac.GESTIONES(
    idgestion       int             IDENTITY(1,1),
    tipo_gestion    varchar(100)    NULL,
    descripcion     varchar(100)    NULL,
    CONSTRAINT PK55 PRIMARY KEY NONCLUSTERED (idgestion)
)
go



IF OBJECT_ID('caac.GESTIONES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.GESTIONES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.GESTIONES >>>'
go

/* 
 * TABLE: caac.H_MENSUAL_ACOMPANIAMIENTO 
 */

CREATE TABLE caac.H_MENSUAL_ACOMPANIAMIENTO(
    idHoja                bigint         NOT NULL,
    idacompaniamiento     int            NOT NULL,
    cantidad_gestiones    int            NULL,
    cantidad_personas     int            NULL,
    h_mens_acomp_uum      varchar(50)    NULL,
    h_mens_acomp_fum      datetime       NULL,
    CONSTRAINT PK42 PRIMARY KEY NONCLUSTERED (idHoja, idacompaniamiento)
)
go



IF OBJECT_ID('caac.H_MENSUAL_ACOMPANIAMIENTO') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.H_MENSUAL_ACOMPANIAMIENTO >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.H_MENSUAL_ACOMPANIAMIENTO >>>'
go

/* 
 * TABLE: caac.H_MENSUAL_ACTIVIDAD 
 */

CREATE TABLE caac.H_MENSUAL_ACTIVIDAD(
    idHoja                bigint         NOT NULL,
    cant_visitas_dom      int            NULL,
    cant_orientaciones    int            NULL,
    cant_grupos           int            NULL,
    cant_entrevistas      int            NULL,
    pers_visitas_dom      int            NULL,
    pers_orientaciones    int            NULL,
    pers_grupos           int            NULL,
    pers_entrevistas      int            NULL,
    cant_orient_calle     int            NULL,
    cant_acomp_calle      int            NULL,
    h_mens_act_uum        varchar(50)    NULL,
    h_mens_act_fum        datetime       NULL,
    CONSTRAINT PK41 PRIMARY KEY NONCLUSTERED (idHoja)
)
go



IF OBJECT_ID('caac.H_MENSUAL_ACTIVIDAD') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.H_MENSUAL_ACTIVIDAD >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.H_MENSUAL_ACTIVIDAD >>>'
go

/* 
 * TABLE: caac.H_MENSUAL_ACTIVIDADES 
 */

CREATE TABLE caac.H_MENSUAL_ACTIVIDADES(
    idHoja                   bigint           NOT NULL,
    idactividad              int              NOT NULL,
    descripcion_actividad    varchar(4000)    NULL,
    h_mens_act_uum           varchar(50)      NULL,
    h_mens_act_fum           datetime         NULL,
    CONSTRAINT PK46 PRIMARY KEY NONCLUSTERED (idHoja, idactividad)
)
go



IF OBJECT_ID('caac.H_MENSUAL_ACTIVIDADES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.H_MENSUAL_ACTIVIDADES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.H_MENSUAL_ACTIVIDADES >>>'
go

/* 
 * TABLE: caac.H_MENSUAL_ALIMENTACION 
 */

CREATE TABLE caac.H_MENSUAL_ALIMENTACION(
    idHoja                   bigint         NOT NULL,
    id_tipo_alimentacion     int            NOT NULL,
    cantidad_personas        int            NULL,
    cantidad_prestaciones    int            NULL,
    h_mensual_alim_uum       varchar(50)    NULL,
    h_mensual_alim_fum       datetime       NULL,
    CONSTRAINT PK40 PRIMARY KEY NONCLUSTERED (idHoja, id_tipo_alimentacion)
)
go



IF OBJECT_ID('caac.H_MENSUAL_ALIMENTACION') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.H_MENSUAL_ALIMENTACION >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.H_MENSUAL_ALIMENTACION >>>'
go

/* 
 * TABLE: caac.H_MENSUAL_ASISTIDOS 
 */

CREATE TABLE caac.H_MENSUAL_ASISTIDOS(
    idHoja               bigint         NOT NULL,
    asist_varones        int            NULL,
    asist_mujeres        int            NULL,
    asist_otro_genero    int            NULL,
    asist_cantidad       int            NULL,
    asist_uum            varchar(50)    NULL,
    asist_fum            datetime       NULL,
    CONSTRAINT PK37 PRIMARY KEY NONCLUSTERED (idHoja)
)
go



IF OBJECT_ID('caac.H_MENSUAL_ASISTIDOS') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.H_MENSUAL_ASISTIDOS >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.H_MENSUAL_ASISTIDOS >>>'
go

/* 
 * TABLE: caac.H_MENSUAL_OBSERVACIONES 
 */

CREATE TABLE caac.H_MENSUAL_OBSERVACIONES(
    idHoja                        bigint           NOT NULL,
    otros_tramites                varchar(500)     NULL,
    alimentacion_en_sede       varchar(300)     NULL,
    alimentacion_fuera_sede       varchar(300)     NULL,
    actividades_familiares        varchar(500)     NULL,
    interv_calle_observ           varchar(2000)    NULL,
    acomp_visitas_estab_salud     varchar(500)     NULL,
    gestiones_estab_salud         varchar(500)     NULL,
    acomp_centro_especial         varchar(500)     NULL,
    asesoramiento_legal           varchar(500)     NULL,
    act_talleres_comisaria        varchar(500)     NULL,
    act_productivas_comisaria     varchar(500)     NULL,
    act_capacitacion_comisaria    varchar(500)     NULL,
    acomp_profesional_salud       varchar(500)     NULL,
    acomp_trayectoria_educ        varchar(500)     NULL,
    mejoras_infraestructura       varchar(2000)    NULL,
    requerimientos_formacion      varchar(4000)    NULL,
    h_mens_obs_uum                varchar(50)      NULL,
    h_mens_obs_fum                datetime         NULL,
    CONSTRAINT PK39 PRIMARY KEY NONCLUSTERED (idHoja)
)
go



IF OBJECT_ID('caac.H_MENSUAL_OBSERVACIONES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.H_MENSUAL_OBSERVACIONES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.H_MENSUAL_OBSERVACIONES >>>'
go

/* 
 * TABLE: caac.H_MENSUAL_PERSONAL 
 */

CREATE TABLE caac.H_MENSUAL_PERSONAL(
    idHoja                 bigint         NOT NULL,
    idempleado             int            NOT NULL,
    alta_baja              char(4)        NULL,
    h_mens_personal_uum    varchar(50)    NULL,
    h_mens_personal_fum    datetime       NULL,
    CONSTRAINT PK47 PRIMARY KEY NONCLUSTERED (idHoja, idempleado)
)
go



IF OBJECT_ID('caac.H_MENSUAL_PERSONAL') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.H_MENSUAL_PERSONAL >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.H_MENSUAL_PERSONAL >>>'
go

/* 
 * TABLE: caac.H_MENSUAL_RECURSOS 
 */

CREATE TABLE caac.H_MENSUAL_RECURSOS(
    idrecursos            int            NOT NULL,
    idHoja                bigint         NOT NULL,
    cant_personas         int            NULL,
    h_mens_recurso_uum    varchar(50)    NULL,
    h_mens_recurso_fum    datetime       NULL,
    CONSTRAINT PK45 PRIMARY KEY NONCLUSTERED (idrecursos, idHoja)
)
go



IF OBJECT_ID('caac.H_MENSUAL_RECURSOS') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.H_MENSUAL_RECURSOS >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.H_MENSUAL_RECURSOS >>>'
go

/* 
 * TABLE: caac.H_MENSUAL_TRAMITES 
 */

CREATE TABLE caac.H_MENSUAL_TRAMITES(
    idHoja                bigint         NOT NULL,
    idtramite             int            NOT NULL,
    cantidad              int            NULL,
    h_mens_tramite_uum    varchar(50)    NULL,
    h_mens_tramite_fum    datetime       NULL,
    CONSTRAINT PK38 PRIMARY KEY NONCLUSTERED (idHoja, idtramite)
)
go



IF OBJECT_ID('caac.H_MENSUAL_TRAMITES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.H_MENSUAL_TRAMITES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.H_MENSUAL_TRAMITES >>>'
go

/* 
 * TABLE: caac.HOJA_ACOMPANIAMIENTO 
 */

CREATE TABLE caac.HOJA_ACOMPANIAMIENTO(
    idHoja               bigint          NOT NULL,
    idacompaniamiento    int             NOT NULL,
    descripcion          varchar(300)    NULL,
    interno              char(1)         NULL,
    externo              char(1)         NULL,
    hoja_acom_uum        varchar(50)     NULL,
    hoja_acom_fum        datetime        NULL,
    CONSTRAINT PK53 PRIMARY KEY NONCLUSTERED (idHoja, idacompaniamiento)
)
go



IF OBJECT_ID('caac.HOJA_ACOMPANIAMIENTO') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_ACOMPANIAMIENTO >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_ACOMPANIAMIENTO >>>'
go

/* 
 * TABLE: caac.HOJA_ACT_INTERVENCION 
 */

CREATE TABLE caac.HOJA_ACT_INTERVENCION(
    idHoja            bigint          NOT NULL,
    idactividad       int             NOT NULL,
    descripcion       varchar(300)    NULL,
    act_interv_uum    varchar(50)     NULL,
    act_interv_fum    datetime        NULL,
    CONSTRAINT PK27 PRIMARY KEY NONCLUSTERED (idHoja, idactividad)
)
go



IF OBJECT_ID('caac.HOJA_ACT_INTERVENCION') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_ACT_INTERVENCION >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_ACT_INTERVENCION >>>'
go

/* 
 * TABLE: caac.HOJA_ALT_ASIST 
 */

CREATE TABLE caac.HOJA_ALT_ASIST(
    idHoja           bigint         NOT NULL,
    idalter_asist    int            NOT NULL,
    descripcion      char(10)       NULL,
    alt_asist_uum    varchar(50)    NULL,
    alt_asist_fum    datetime       NULL,
    CONSTRAINT PK15 PRIMARY KEY NONCLUSTERED (idHoja, idalter_asist)
)
go



IF OBJECT_ID('caac.HOJA_ALT_ASIST') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_ALT_ASIST >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_ALT_ASIST >>>'
go

/* 
 * TABLE: caac.HOJA_ARTICULACION_INST 
 */

CREATE TABLE caac.HOJA_ARTICULACION_INST(
    idHoja                  bigint          NOT NULL,
    id_tipo_inst            int             NOT NULL,
    ningun_vinculo          char(1)         NULL,
    intercambio_info        char(1)         NULL,
    deriv_recep_personal    char(1)         NULL,
    acciones_conjuntas      char(1)         NULL,
    proyectos_conjuntos     char(1)         NULL,
    nombre_institucion      varchar(300)    NULL,
    artic_inst_uum          varchar(50)     NULL,
    artic_inst_fum          datetime        NULL,
    CONSTRAINT PK33 PRIMARY KEY NONCLUSTERED (idHoja, id_tipo_inst)
)
go



IF OBJECT_ID('caac.HOJA_ARTICULACION_INST') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_ARTICULACION_INST >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_ARTICULACION_INST >>>'
go

/* 
 * TABLE: caac.HOJA_CAAC 
 */

CREATE TABLE caac.HOJA_CAAC(
    idHoja               bigint         IDENTITY(1,1),
    anio                 int            NULL,
    idmes                int            NULL,
    idcaac               int            NOT NULL,
    tipo_hoja            char(1)        NULL,
    hoja_fecha_cierre    datetime       NULL,
    hoja_uum             varchar(50)    NULL,
    hoja_fum             datetime       NULL,
    CONSTRAINT PK10 PRIMARY KEY NONCLUSTERED (idHoja)
)
go



IF OBJECT_ID('caac.HOJA_CAAC') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_CAAC >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_CAAC >>>'
go

/* 
 * TABLE: caac.HOJA_DATOS_INICIALES 
 */

CREATE TABLE caac.HOJA_DATOS_INICIALES(
    idHoja                    bigint           NOT NULL,
    nombre_caac               varchar(300)     NULL,
    org_responsable           varchar(300)     NULL,
    pers_responsable          varchar(300)     NULL,
    tel_responsable           varchar(100)     NULL,
    mail_responsable          varchar(300)     NULL,
    otros_referentes          varchar(4000)    NULL,
    direccion                 varchar(300)     NULL,
    interseccion_1            varchar(300)     NULL,
    interseccion_2            varchar(300)     NULL,
    barrio                    varchar(300)     NULL,
    idlocalidad               int              NULL,
    idmunicipio               int              NULL,
    iddepto                   int              NULL,
    idprovincia               int              NULL,
    anexos                    char(1)          NULL,
    dir_horario_anexos        varchar(4000)    NULL,
    caracteristicas_grales    varchar(4000)    NULL,
    tel_caac                  varchar(100)     NULL,
    mail_caac                 varchar(100)     NULL,
    datos_iniciales_uum       varchar(50)      NULL,
    datos_iniciales_fum       datetime         NULL,
    CONSTRAINT PK14 PRIMARY KEY NONCLUSTERED (idHoja)
)
go



IF OBJECT_ID('caac.HOJA_DATOS_INICIALES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_DATOS_INICIALES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_DATOS_INICIALES >>>'
go

/* 
 * TABLE: caac.HOJA_DIAS_ATENCION 
 */

CREATE TABLE caac.HOJA_DIAS_ATENCION(
    idHoja              bigint         NOT NULL,
    id                  int            NOT NULL,
    horario             varchar(50)    NULL,
    dia_atencion_uum    varchar(50)    NULL,
    dia_atencion_fum    datetime       NULL,
    CONSTRAINT PK48 PRIMARY KEY NONCLUSTERED (idHoja, id)
)
go



IF OBJECT_ID('caac.HOJA_DIAS_ATENCION') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_DIAS_ATENCION >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_DIAS_ATENCION >>>'
go

/* 
 * TABLE: caac.HOJA_EDUCACION_ACTIVIDADES 
 */

CREATE TABLE caac.HOJA_EDUCACION_ACTIVIDADES(
    idHoja                      bigint          NOT NULL,
    edu_acomp_escuela           char(1)         NULL,
    edu_prevencion              char(1)         NULL,
    edu_apoyo_escolar           char(1)         NULL,
    edu_programa_inclusion      char(1)         NULL,
    edu_escuela_en_sede         char(1)         NULL,
    edu_otro                    char(1)         NULL,
    edu_otro_descripcion        varchar(100)    NULL,
    act_deportivas              char(1)         NULL,
    act_capacitacion_oficios    char(1)         NULL,
    act_culturales              char(1)         NULL,
    act_recreativas             char(1)         NULL,
    act_eventos_festivos        char(1)         NULL,
    act_religiosas              char(1)         NULL,
    act_otro                    char(1)         NULL,
    act_otro_descripcion        varchar(100)    NULL,
    edu_act_uum                 varchar(50)     NULL,
    edu_act_fum                 datetime        NULL,
    CONSTRAINT PK31 PRIMARY KEY NONCLUSTERED (idHoja)
)
go



IF OBJECT_ID('caac.HOJA_EDUCACION_ACTIVIDADES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_EDUCACION_ACTIVIDADES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_EDUCACION_ACTIVIDADES >>>'
go

/* 
 * TABLE: caac.HOJA_ESTRUCTURA 
 */

CREATE TABLE caac.HOJA_ESTRUCTURA(
    idHoja            bigint          NOT NULL,
    idespacio         int             NOT NULL,
    cantidad          int             NULL,
    descripcion       varchar(300)    NULL,
    estructura_uum    varchar(50)     NULL,
    estructura_fum    datetime        NULL,
    CONSTRAINT PK36 PRIMARY KEY NONCLUSTERED (idHoja, idespacio)
)
go



IF OBJECT_ID('caac.HOJA_ESTRUCTURA') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_ESTRUCTURA >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_ESTRUCTURA >>>'
go

/* 
 * TABLE: caac.HOJA_GESTION_ALIMENTACION 
 */

CREATE TABLE caac.HOJA_GESTION_ALIMENTACION(
    idHoja                      bigint          NOT NULL,
    idalimentacion              int             NOT NULL,
    descripcion                 varchar(100)    NULL,
    gestion_alimentacion_uum    varchar(50)     NULL,
    gestion_alimentacion_fum    datetime        NULL,
    CONSTRAINT PK24 PRIMARY KEY NONCLUSTERED (idHoja, idalimentacion)
)
go



IF OBJECT_ID('caac.HOJA_GESTION_ALIMENTACION') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_GESTION_ALIMENTACION >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_GESTION_ALIMENTACION >>>'
go

/* 
 * TABLE: caac.HOJA_GESTION_TRAMITES 
 */

CREATE TABLE caac.HOJA_GESTION_TRAMITES(
    idHoja              bigint          NOT NULL,
    idtramite           int             NOT NULL,
    descripcion_otro    varchar(100)    NULL,
    tramite_uum         varchar(50)     NULL,
    tramite_fum         datetime        NULL,
    CONSTRAINT PK23 PRIMARY KEY NONCLUSTERED (idHoja, idtramite)
)
go



IF OBJECT_ID('caac.HOJA_GESTION_TRAMITES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_GESTION_TRAMITES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_GESTION_TRAMITES >>>'
go

/* 
 * TABLE: caac.HOJA_LEGALES 
 */

CREATE TABLE caac.HOJA_LEGALES(
    idHoja                    bigint          NOT NULL,
    acomp_comisarias          char(1)         NULL,
    acomp_penales             char(1)         NULL,
    acomp_otro                char(1)         NULL,
    acomp_otro_descripcion    varchar(100)    NULL,
    activ_talleres            char(1)         NULL,
    activ_productivas         char(1)         NULL,
    activ_capacitacion        char(1)         NULL,
    activ_otro                char(1)         NULL,
    activ_otro_descripcion    varchar(100)    NULL,
    legales_uum               varchar(50)     NULL,
    legales_fum               datetime        NULL,
    CONSTRAINT PK29 PRIMARY KEY NONCLUSTERED (idHoja)
)
go



IF OBJECT_ID('caac.HOJA_LEGALES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_LEGALES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_LEGALES >>>'
go

/* 
 * TABLE: caac.HOJA_OBSERVACIONES 
 */

CREATE TABLE caac.HOJA_OBSERVACIONES(
    idHoja                     bigint           NOT NULL,
    alimentacion_en_sede       varchar(4000)    NULL,
    alimentacion_fuera_sede    varchar(4000)    NULL,
    actividades_familiares     varchar(4000)    NULL,
    intervencion_calle         varchar(4000)    NULL,
    acompaniam_visitas         varchar(4000)    NULL,
    asesoram_legal             varchar(4000)    NULL,
    orientacion_salud          varchar(4000)    NULL,
    trayectorias_educativas    varchar(4000)    NULL,
    dificultades_obstaculos    varchar(4000)    NULL,
    observ_personal            varchar(4000)    NULL,
    espacio_prod_veg_anim      varchar(4000)    NULL,
    maquinaria_trabajo         varchar(4000)    NULL,
    observaciones_uum          varchar(50)      NULL,
    observaciones_fum          datetime         NULL,
    CONSTRAINT PK26 PRIMARY KEY NONCLUSTERED (idHoja)
)
go



IF OBJECT_ID('caac.HOJA_OBSERVACIONES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_OBSERVACIONES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_OBSERVACIONES >>>'
go

/* 
 * TABLE: caac.HOJA_PERSONAL 
 */

CREATE TABLE caac.HOJA_PERSONAL(
    idHoja           bigint         NOT NULL,
    idempleado       int            NOT NULL,
    hpersonal_uum    varchar(50)    NULL,
    hpersonal_fum    datetime       NULL,
    CONSTRAINT PK35 PRIMARY KEY NONCLUSTERED (idHoja, idempleado)
)
go



IF OBJECT_ID('caac.HOJA_PERSONAL') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_PERSONAL >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_PERSONAL >>>'
go

/* 
 * TABLE: caac.HOJA_PERSONAL_HORAS 
 */

CREATE TABLE caac.HOJA_PERSONAL_HORAS(
    idHoja                 bigint         NOT NULL,
    idprofesion            int            NOT NULL,
    cant_rentado_hs        int            NULL,
    cant_rentado_pers      int            NULL,
    cant_norentado_hs      int            NULL,
    cant_norentado_pers    int            NULL,
    personal_hs_uum        varchar(50)    NULL,
    personal_hs_fum        datetime       NULL,
    CONSTRAINT PK60 PRIMARY KEY NONCLUSTERED (idHoja, idprofesion)
)
go



IF OBJECT_ID('caac.HOJA_PERSONAL_HORAS') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_PERSONAL_HORAS >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_PERSONAL_HORAS >>>'
go

/* 
 * TABLE: caac.HOJA_POBL_ASISTIDA_ACTIV 
 */

CREATE TABLE caac.HOJA_POBL_ASISTIDA_ACTIV(
    idHoja                    bigint          NOT NULL,
    idpoblacion               int             NOT NULL,
    descripcion               varchar(300)    NULL,
    pob_asistida_activ_uum    varchar(50)     NULL,
    pob_asistida_activ_fum    datetime        NULL,
    CONSTRAINT PK17 PRIMARY KEY NONCLUSTERED (idHoja, idpoblacion)
)
go



IF OBJECT_ID('caac.HOJA_POBL_ASISTIDA_ACTIV') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_POBL_ASISTIDA_ACTIV >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_POBL_ASISTIDA_ACTIV >>>'
go

/* 
 * TABLE: caac.HOJA_POBL_ASISTIDA_CONSUMO 
 */

CREATE TABLE caac.HOJA_POBL_ASISTIDA_CONSUMO(
    idHoja                      bigint          NOT NULL,
    idpoblacion                 int             NOT NULL,
    descripcion                 varchar(300)    NULL,
    pob_asistida_consumo_uum    varchar(50)     NULL,
    pob_asistida_consumo_fum    datetime        NULL,
    CONSTRAINT PK16 PRIMARY KEY NONCLUSTERED (idHoja, idpoblacion)
)
go



IF OBJECT_ID('caac.HOJA_POBL_ASISTIDA_CONSUMO') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_POBL_ASISTIDA_CONSUMO >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_POBL_ASISTIDA_CONSUMO >>>'
go

/* 
 * TABLE: caac.HOJA_RECURSOS 
 */

CREATE TABLE caac.HOJA_RECURSOS(
    idHoja         bigint          NOT NULL,
    id             int             NOT NULL,
    descripcion    varchar(300)    NULL,
    recurso_uum    varchar(50)     NULL,
    recurso_fum    datetime        NULL,
    CONSTRAINT PK56 PRIMARY KEY NONCLUSTERED (idHoja, id)
)
go



IF OBJECT_ID('caac.HOJA_RECURSOS') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_RECURSOS >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_RECURSOS >>>'
go

/* 
 * TABLE: caac.HOJA_REGISTROS_INSTITUCIONALES 
 */

CREATE TABLE caac.HOJA_REGISTROS_INSTITUCIONALES(
    idHoja                bigint         NOT NULL,
    idclasif_registros    int            NOT NULL,
    si_papel              char(1)        NULL,
    si_informatico        char(10)       NULL,
    reg_uum               varchar(50)    NULL,
    reg_fum               datetime       NULL,
    CONSTRAINT PK18 PRIMARY KEY NONCLUSTERED (idHoja, idclasif_registros)
)
go



IF OBJECT_ID('caac.HOJA_REGISTROS_INSTITUCIONALES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_REGISTROS_INSTITUCIONALES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_REGISTROS_INSTITUCIONALES >>>'
go

/* 
 * TABLE: caac.HOJA_SALUD 
 */

CREATE TABLE caac.HOJA_SALUD(
    idHoja         bigint          NOT NULL,
    idgestion      int             NOT NULL,
    hsalud_uum     varchar(50)     NULL,
    descripcion    varchar(300)    NULL,
    hsalud_fum     datetime        NULL,
    CONSTRAINT PK54 PRIMARY KEY NONCLUSTERED (idHoja, idgestion)
)
go



IF OBJECT_ID('caac.HOJA_SALUD') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.HOJA_SALUD >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.HOJA_SALUD >>>'
go

/* 
 * TABLE: caac.logs 
 */

CREATE TABLE caac.logs(
    id           int              IDENTITY(4257,1),
    usuario      varchar(40)      NOT NULL,
    fech_hora    varchar(30)      NOT NULL,
    cambios      varchar(4000)    NOT NULL,
    CONSTRAINT PK5_logs PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('caac.logs') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.logs >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.logs >>>'
go

/* 
 * TABLE: caac.pagos 
 */

CREATE TABLE caac.pagos(
    id               int             IDENTITY(1297,1),
    caac             int             NOT NULL,
    mes              varchar(20)     NOT NULL,
    anio             int             NOT NULL,
    num_fac          varchar(30)     NULL,
    fech_resep       date            NULL,
    num_exp          varchar(30)     NULL,
    fech_pag         date            NULL,
    monto            float           NULL,
    asistidos        int             NULL,
    observaciones    varchar(400)    NULL,
    atendidos        int             NULL,
    CONSTRAINT PK7_pagos PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('caac.pagos') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.pagos >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.pagos >>>'
go

/* 
 * TABLE: caac.PERSONAL 
 */

CREATE TABLE caac.PERSONAL(
    idempleado       int             IDENTITY(1,1),
    idprofesion      int             NOT NULL,
    nombre           varchar(100)    NULL,
    apellido         varchar(100)    NULL,
    hs_semanales     int             NULL,
    rol              varchar(100)    NULL,
    titulo           varchar(100)    NULL,
    es_rentado       char(1)         NULL,
    estado_actual    char(4)         NULL,
    personal_uum     varchar(50)     NULL,
    personal_fum     datetime        NULL,
    CONSTRAINT PK34 PRIMARY KEY NONCLUSTERED (idempleado)
)
go



IF OBJECT_ID('caac.PERSONAL') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.PERSONAL >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.PERSONAL >>>'
go

/* 
 * TABLE: caac.POBLACION 
 */

CREATE TABLE caac.POBLACION(
    idpoblacion    int             IDENTITY(1,1),
    descripcion    varchar(100)    NULL,
    CONSTRAINT PK51 PRIMARY KEY NONCLUSTERED (idpoblacion)
)
go



IF OBJECT_ID('caac.POBLACION') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.POBLACION >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.POBLACION >>>'
go

/* 
 * TABLE: caac.RECURSOS 
 */

CREATE TABLE caac.RECURSOS(
    id         int            IDENTITY(1,1),
    detalle    varchar(50)    NULL,
    CONSTRAINT PK44 PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('caac.RECURSOS') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.RECURSOS >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.RECURSOS >>>'
go

/* 
 * TABLE: caac.requisitos 
 */

CREATE TABLE caac.requisitos(
    id             int            IDENTITY(125,1),
    idcaac         int            NOT NULL,
    fotodni        varchar(20)    NOT NULL,
    soliform       varchar(20)    NOT NULL,
    perjur         varchar(20)    NOT NULL,
    statuto        varchar(20)    NOT NULL,
    actaasa        varchar(20)    NOT NULL,
    desaut         varchar(20)    NOT NULL,
    forafip        varchar(20)    NOT NULL,
    prodesex       varchar(20)    NOT NULL,
    segrescivil    varchar(20)    NOT NULL,
    segmalpra      varchar(20)    NOT NULL,
    lisrrhh        varchar(20)    NOT NULL,
    cvsliscom      varchar(20)    NOT NULL,
    organi         varchar(20)    NOT NULL,
    cronalimen     varchar(20)    NOT NULL,
    cronmerc       varchar(20)    NOT NULL,
    cronparad      varchar(20)    NOT NULL,
    crondiayh      varchar(20)    NOT NULL,
    altbanca       varchar(20)    NOT NULL,
    CONSTRAINT PK10_requisitos PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('caac.requisitos') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.requisitos >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.requisitos >>>'
go

/* 
 * TABLE: caac.TRAMITES 
 */

CREATE TABLE caac.TRAMITES(
    id             int            IDENTITY(1,1),
    descripcion    varchar(50)    NULL,
    CONSTRAINT PK22 PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('caac.TRAMITES') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.TRAMITES >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.TRAMITES >>>'
go

/* 
 * TABLE: caac.vencimientos 
 */

CREATE TABLE caac.vencimientos(
    id                 int             IDENTITY(129,1),
    idcaac             int             NOT NULL,
    asamrecib          date            NOT NULL,
    asambaja           date            NOT NULL,
    autorirecib        date            NOT NULL,
    autoribaja         date            NOT NULL,
    afiprecib          date            NOT NULL,
    afipbaja           date            NOT NULL,
    responrecib        date            NOT NULL,
    responbaja         date            NOT NULL,
    malapra1           varchar(100)    NOT NULL,
    malapra2           varchar(100)    NOT NULL,
    malapra3           varchar(100)    NOT NULL,
    malapra4           varchar(100)    NOT NULL,
    malapra5           varchar(100)    NOT NULL,
    malapra6           varchar(100)    NOT NULL,
    malapra7           varchar(100)    NOT NULL,
    malapra8           varchar(100)    NOT NULL,
    malapra9           varchar(100)    NOT NULL,
    malapra10          varchar(100)    NOT NULL,
    fech_rec_mala1     date            NOT NULL,
    fech_rec_mala2     date            NOT NULL,
    fech_rec_mala3     date            NOT NULL,
    fech_rec_mala4     date            NOT NULL,
    fech_rec_mala5     date            NOT NULL,
    fech_rec_mala6     date            NOT NULL,
    fech_rec_mala7     date            NOT NULL,
    fech_rec_mala8     date            NOT NULL,
    fech_rec_mala9     date            NOT NULL,
    fech_rec_mala10    date            NOT NULL,
    fech_ven_mala1     date            NOT NULL,
    fech_ven_mala2     date            NOT NULL,
    fech_ven_mala3     date            NOT NULL,
    fech_ven_mala4     date            NOT NULL,
    fech_ven_mala5     date            NOT NULL,
    fech_ven_mala6     date            NOT NULL,
    fech_ven_mala7     date            NOT NULL,
    fech_ven_mala8     date            NOT NULL,
    fech_ven_mala9     date            NOT NULL,
    fech_ven_mala10    date            NOT NULL,
    CONSTRAINT PK12_vencimientos PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('caac.vencimientos') IS NOT NULL
    PRINT '<<< CREATED TABLE caac.vencimientos >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE caac.vencimientos >>>'
go

/* 
 * TABLE: DIA 
 */

CREATE TABLE DIA(
    id             int            IDENTITY(1,1),
    descripcion    varchar(10)    NULL,
    CONSTRAINT PK49 PRIMARY KEY NONCLUSTERED (id)
)
go



IF OBJECT_ID('DIA') IS NOT NULL
    PRINT '<<< CREATED TABLE DIA >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE DIA >>>'
go

/* 
 * TABLE: ESPACIOS 
 */

CREATE TABLE ESPACIOS(
    idespacio      int             IDENTITY(1,1),
    descripcion    varchar(100)    NULL,
    CONSTRAINT PK59 PRIMARY KEY NONCLUSTERED (idespacio)
)
go



IF OBJECT_ID('ESPACIOS') IS NOT NULL
    PRINT '<<< CREATED TABLE ESPACIOS >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE ESPACIOS >>>'
go

/* 
 * TABLE: HOJA_REUNIONES_EQUIPO 
 */

CREATE TABLE HOJA_REUNIONES_EQUIPO(
    idHoja           bigint         NOT NULL,
    si               char(1)        NULL,
    no               char(1)        NULL,
    idfrecuencia     int            NOT NULL,
    reuniones_uum    varchar(10)    NULL,
    reuniones_fum    datetime       NULL,
    CONSTRAINT PK20 PRIMARY KEY NONCLUSTERED (idHoja)
)
go



IF OBJECT_ID('HOJA_REUNIONES_EQUIPO') IS NOT NULL
    PRINT '<<< CREATED TABLE HOJA_REUNIONES_EQUIPO >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE HOJA_REUNIONES_EQUIPO >>>'
go

/* 
 * TABLE: TIPO_INSTITUCION 
 */

CREATE TABLE TIPO_INSTITUCION(
    id_tipo_inst    int             IDENTITY(1,1),
    descripcion     varchar(100)    NULL,
    CONSTRAINT PK58 PRIMARY KEY NONCLUSTERED (id_tipo_inst)
)
go



IF OBJECT_ID('TIPO_INSTITUCION') IS NOT NULL
    PRINT '<<< CREATED TABLE TIPO_INSTITUCION >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE TIPO_INSTITUCION >>>'
go

/* 
 * TABLE: caac.auditorias 
 */

ALTER TABLE caac.auditorias ADD CONSTRAINT FK_CASAS_AUDITORIA 
    FOREIGN KEY (id)
    REFERENCES caac.casas(id)
go


/* 
 * TABLE: caac.casas 
 */

ALTER TABLE caac.casas ADD CONSTRAINT FK_CASAS_CATEGORIA 
    FOREIGN KEY (cat)
    REFERENCES caac.categorias(cat)
go

ALTER TABLE caac.casas ADD CONSTRAINT FK_CASAS_NCAT 
    FOREIGN KEY (ncat)
    REFERENCES caac.categorias(cat)
go


/* 
 * TABLE: caac.H_MENSUAL_ACOMPANIAMIENTO 
 */

ALTER TABLE caac.H_MENSUAL_ACOMPANIAMIENTO ADD CONSTRAINT FK_ACOMP_HMACOMP 
    FOREIGN KEY (idacompaniamiento)
    REFERENCES caac.ACOMPANIAMIENTO(idacompaniamiento)
go

ALTER TABLE caac.H_MENSUAL_ACOMPANIAMIENTO ADD CONSTRAINT FK_CAAC_HMENSACOMP 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.H_MENSUAL_ACTIVIDAD 
 */

ALTER TABLE caac.H_MENSUAL_ACTIVIDAD ADD CONSTRAINT [FK_HCAAC_MENACTIV] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.H_MENSUAL_ACTIVIDADES 
 */

ALTER TABLE caac.H_MENSUAL_ACTIVIDADES ADD CONSTRAINT FK_ACTINT_HMACT 
    FOREIGN KEY (idactividad)
    REFERENCES caac.ACTIVIDADES_INTERVENCIONES(idactividad)
go

ALTER TABLE caac.H_MENSUAL_ACTIVIDADES ADD CONSTRAINT [FK_HCAAC_HMENACTIVS] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.H_MENSUAL_ALIMENTACION 
 */

ALTER TABLE caac.H_MENSUAL_ALIMENTACION ADD CONSTRAINT FK_ALIM_HMALIM 
    FOREIGN KEY (id_tipo_alimentacion)
    REFERENCES caac.ALIMENTACION(id)
go

ALTER TABLE caac.H_MENSUAL_ALIMENTACION ADD CONSTRAINT [FK_HCAAC_HMENALIM] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.H_MENSUAL_ASISTIDOS 
 */

ALTER TABLE caac.H_MENSUAL_ASISTIDOS ADD CONSTRAINT [FK_HCAAC_HMENASIST] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.H_MENSUAL_OBSERVACIONES 
 */

ALTER TABLE caac.H_MENSUAL_OBSERVACIONES ADD CONSTRAINT [FK_HCAAC_HMENOBS] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.H_MENSUAL_PERSONAL 
 */

ALTER TABLE caac.H_MENSUAL_PERSONAL ADD CONSTRAINT [FK_HCAAC_HMENPERS] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go

ALTER TABLE caac.H_MENSUAL_PERSONAL ADD CONSTRAINT FK_PERS_HMPERS 
    FOREIGN KEY (idempleado)
    REFERENCES caac.PERSONAL(idempleado)
go


/* 
 * TABLE: caac.H_MENSUAL_RECURSOS 
 */

ALTER TABLE caac.H_MENSUAL_RECURSOS ADD CONSTRAINT [FK_HCAAC_HMENREC] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go

ALTER TABLE caac.H_MENSUAL_RECURSOS ADD CONSTRAINT FK_RECU_HMECU 
    FOREIGN KEY (idrecursos)
    REFERENCES caac.RECURSOS(id)
go


/* 
 * TABLE: caac.H_MENSUAL_TRAMITES 
 */

ALTER TABLE caac.H_MENSUAL_TRAMITES ADD CONSTRAINT [FK_HCAAC_HMENTRAM] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go

ALTER TABLE caac.H_MENSUAL_TRAMITES ADD CONSTRAINT FK_TRAMITE_HMTRAM 
    FOREIGN KEY (idtramite)
    REFERENCES caac.TRAMITES(id)
go


/* 
 * TABLE: caac.HOJA_ACOMPANIAMIENTO 
 */

ALTER TABLE caac.HOJA_ACOMPANIAMIENTO ADD CONSTRAINT FK_ACOMP_HACOMP 
    FOREIGN KEY (idacompaniamiento)
    REFERENCES caac.ACOMPANIAMIENTO(idacompaniamiento)
go

ALTER TABLE caac.HOJA_ACOMPANIAMIENTO ADD CONSTRAINT [FK_HCAAC_HACOMP] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_ACT_INTERVENCION 
 */

ALTER TABLE caac.HOJA_ACT_INTERVENCION ADD CONSTRAINT FK_ACTINT_HACTINT 
    FOREIGN KEY (idactividad)
    REFERENCES caac.ACTIVIDADES_INTERVENCIONES(idactividad)
go

ALTER TABLE caac.HOJA_ACT_INTERVENCION ADD CONSTRAINT [FK_HCAAC_HAINTER] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_ALT_ASIST 
 */

ALTER TABLE caac.HOJA_ALT_ASIST ADD CONSTRAINT FK_ALTERN_HALTASIST 
    FOREIGN KEY (idalter_asist)
    REFERENCES caac.ALTERNATIVAS_ASISTENCIALES(id)
go

ALTER TABLE caac.HOJA_ALT_ASIST ADD CONSTRAINT FK_HDATO_ALTASIST 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_DATOS_INICIALES(idHoja)
go


/* 
 * TABLE: caac.HOJA_ARTICULACION_INST 
 */

ALTER TABLE caac.HOJA_ARTICULACION_INST ADD CONSTRAINT [FK_HCAAC_HARTINST] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go

ALTER TABLE caac.HOJA_ARTICULACION_INST ADD CONSTRAINT FK_TINST_HARTIC 
    FOREIGN KEY (id_tipo_inst)
    REFERENCES TIPO_INSTITUCION(id_tipo_inst)
go


/* 
 * TABLE: caac.HOJA_CAAC 
 */

ALTER TABLE caac.HOJA_CAAC ADD CONSTRAINT FK_CASAS_HOJACAAC 
    FOREIGN KEY (idcaac)
    REFERENCES caac.casas(id)
go


/* 
 * TABLE: caac.HOJA_DATOS_INICIALES 
 */

ALTER TABLE caac.HOJA_DATOS_INICIALES ADD CONSTRAINT [FK_HCAAC_HDATOS] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_DIAS_ATENCION 
 */

ALTER TABLE caac.HOJA_DIAS_ATENCION ADD CONSTRAINT FK_DIA_HDATENCION 
    FOREIGN KEY (id)
    REFERENCES DIA(id)
go

ALTER TABLE caac.HOJA_DIAS_ATENCION ADD CONSTRAINT [FK_HCAAC_HDIAS] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_EDUCACION_ACTIVIDADES 
 */

ALTER TABLE caac.HOJA_EDUCACION_ACTIVIDADES ADD CONSTRAINT [FK_HCAAC_HEDUC] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_ESTRUCTURA 
 */

ALTER TABLE caac.HOJA_ESTRUCTURA ADD CONSTRAINT FK_ESPACIOS_HESTRUCTURA 
    FOREIGN KEY (idespacio)
    REFERENCES ESPACIOS(idespacio)
go

ALTER TABLE caac.HOJA_ESTRUCTURA ADD CONSTRAINT [FK_HCAAC_HESTRUCT] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_GESTION_ALIMENTACION 
 */

ALTER TABLE caac.HOJA_GESTION_ALIMENTACION ADD CONSTRAINT FK_ALIM_HGALIM 
    FOREIGN KEY (idalimentacion)
    REFERENCES caac.ALIMENTACION(id)
go

ALTER TABLE caac.HOJA_GESTION_ALIMENTACION ADD CONSTRAINT [FK_HCAAC_HGALIM] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_GESTION_TRAMITES 
 */

ALTER TABLE caac.HOJA_GESTION_TRAMITES ADD CONSTRAINT [FK_HCAAC_HGTRAM] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go

ALTER TABLE caac.HOJA_GESTION_TRAMITES ADD CONSTRAINT FK_TRAMITE_HTRAM 
    FOREIGN KEY (idtramite)
    REFERENCES caac.TRAMITES(id)
go


/* 
 * TABLE: caac.HOJA_LEGALES 
 */

ALTER TABLE caac.HOJA_LEGALES ADD CONSTRAINT [FK_HCAAC_HLEGAL] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_OBSERVACIONES 
 */

ALTER TABLE caac.HOJA_OBSERVACIONES ADD CONSTRAINT [FK_HCAAC_HOBS] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_PERSONAL 
 */

ALTER TABLE caac.HOJA_PERSONAL ADD CONSTRAINT [FK_HCAAC_HPERSONAL] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go

ALTER TABLE caac.HOJA_PERSONAL ADD CONSTRAINT FK_PERS_HPERS 
    FOREIGN KEY (idempleado)
    REFERENCES caac.PERSONAL(idempleado)
go


/* 
 * TABLE: caac.HOJA_PERSONAL_HORAS 
 */

ALTER TABLE caac.HOJA_PERSONAL_HORAS ADD CONSTRAINT FK_HCAAC_PERHORAS 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_POBL_ASISTIDA_ACTIV 
 */

ALTER TABLE caac.HOJA_POBL_ASISTIDA_ACTIV ADD CONSTRAINT [FK_HCAAC_HPOACTIV] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go

ALTER TABLE caac.HOJA_POBL_ASISTIDA_ACTIV ADD CONSTRAINT FK_POBLA_ACTIV 
    FOREIGN KEY (idpoblacion)
    REFERENCES caac.POBLACION(idpoblacion)
go


/* 
 * TABLE: caac.HOJA_POBL_ASISTIDA_CONSUMO 
 */

ALTER TABLE caac.HOJA_POBL_ASISTIDA_CONSUMO ADD CONSTRAINT [FK_HCAAC_HPOCONS] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go

ALTER TABLE caac.HOJA_POBL_ASISTIDA_CONSUMO ADD CONSTRAINT FK_POBLA_CONSUMO 
    FOREIGN KEY (idpoblacion)
    REFERENCES caac.POBLACION(idpoblacion)
go


/* 
 * TABLE: caac.HOJA_RECURSOS 
 */

ALTER TABLE caac.HOJA_RECURSOS ADD CONSTRAINT [FK_HCAAC_HRECURSO] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go

ALTER TABLE caac.HOJA_RECURSOS ADD CONSTRAINT FK_RECURSO_HRECU 
    FOREIGN KEY (id)
    REFERENCES caac.RECURSOS(id)
go


/* 
 * TABLE: caac.HOJA_REGISTROS_INSTITUCIONALES 
 */

ALTER TABLE caac.HOJA_REGISTROS_INSTITUCIONALES ADD CONSTRAINT FK_CLREG_HREGINST 
    FOREIGN KEY (idclasif_registros)
    REFERENCES caac.CLASIFICACION_REGISTROS(idclasif_registros)
go

ALTER TABLE caac.HOJA_REGISTROS_INSTITUCIONALES ADD CONSTRAINT [FK_HCAAC_HREGINST] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.HOJA_SALUD 
 */

ALTER TABLE caac.HOJA_SALUD ADD CONSTRAINT FK_GESTION_HSALUD 
    FOREIGN KEY (idgestion)
    REFERENCES caac.GESTIONES(idgestion)
go

ALTER TABLE caac.HOJA_SALUD ADD CONSTRAINT [FK_HCAAC_HSALUD] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


/* 
 * TABLE: caac.pagos 
 */

ALTER TABLE caac.pagos ADD CONSTRAINT FK_CASAS_PAGOS 
    FOREIGN KEY (caac)
    REFERENCES caac.casas(id) ON DELETE CASCADE ON UPDATE CASCADE
go


/* 
 * TABLE: caac.requisitos 
 */

ALTER TABLE caac.requisitos ADD CONSTRAINT FK_CASAS_REQ 
    FOREIGN KEY (idcaac)
    REFERENCES caac.casas(id)
go

ALTER TABLE caac.requisitos ADD CONSTRAINT FK_CASAS_REQUISITO 
    FOREIGN KEY (idcaac)
    REFERENCES caac.casas(id) ON DELETE CASCADE ON UPDATE CASCADE
go


/* 
 * TABLE: caac.vencimientos 
 */

ALTER TABLE caac.vencimientos ADD CONSTRAINT FK_CASAS_VENCIMIENTO 
    FOREIGN KEY (idcaac)
    REFERENCES caac.casas(id)
go


/* 
 * TABLE: HOJA_REUNIONES_EQUIPO 
 */

ALTER TABLE HOJA_REUNIONES_EQUIPO ADD CONSTRAINT FK_CLFREC_HREQUIP 
    FOREIGN KEY (idfrecuencia)
    REFERENCES caac.CLASIFICACION_FRECUENCIA(id)
go

ALTER TABLE HOJA_REUNIONES_EQUIPO ADD CONSTRAINT [FK_HCAAC_HREUNION] 
    FOREIGN KEY (idHoja)
    REFERENCES caac.HOJA_CAAC(idHoja)
go


alter table caac.hoja_caac
add CONSTRAINT FK_HOJA_CAAC_MES foreign key (idmes)
references commons_models.mes (mes_id)
go

alter table caac.hoja_datos_iniciales
add CONSTRAINT FK_HOJA_LOCALIDAD foreign key (idlocalidad)
references geo.localidad (id)
go

alter table caac.hoja_datos_iniciales
add CONSTRAINT FK_HOJA_MUNICIPIO foreign key (idmunicipio)
references geo.municipio (muni_id)
go

alter table caac.hoja_datos_iniciales
add CONSTRAINT FK_HOJA_DEPTO foreign key (iddepto)
references geo.departamento (id)
go

alter table caac.hoja_datos_iniciales
add CONSTRAINT FK_HOJA_PROVINCIA foreign key (idprovincia)
references geo.provincia (id)
go

alter table caac.personal
add CONSTRAINT FK_PERSONAL_PROFESION foreign key (idprofesion)
references commons_models.profesion (prof_id)
go

alter table caac.hoja_estructura
add CONSTRAINT FK_HOJA_AMENITIES foreign key (idespacio)
references dispositivos.amenities (ame_id)
go