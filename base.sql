
CREATE CACHED TABLE "PUBLIC"."TELEFONO"(
    "CITYCODE" CHARACTER VARYING(255),
    "COUNTRYCODE" CHARACTER VARYING(255),
    "ID" CHARACTER VARYING(255) NOT NULL,
    "NUMBER" CHARACTER VARYING(255),
    "USUARIO_ID" CHARACTER VARYING(255)
);     
ALTER TABLE "PUBLIC"."TELEFONO" ADD CONSTRAINT "PUBLIC"."PK_TELEFONO" PRIMARY KEY("ID");     
CREATE CACHED TABLE "PUBLIC"."USUARIO"(
    "ISACTIVE" BOOLEAN,
    "CREATED" TIMESTAMP(6),
    "LAST_LOGIN" TIMESTAMP(6),
    "MODIFIED" TIMESTAMP(6),
    "EMAIL" CHARACTER VARYING(255),
    "ID" CHARACTER VARYING(255) NOT NULL,
    "NAME" CHARACTER VARYING(255),
    "PASSWORD" CHARACTER VARYING(255),
    "TOKEN" CHARACTER VARYING(1000)
);               
ALTER TABLE "PUBLIC"."USUARIO" ADD CONSTRAINT "PUBLIC"."PK_USUARIO" PRIMARY KEY("ID");     
ALTER TABLE "PUBLIC"."USUARIO" ADD CONSTRAINT "PUBLIC"."UK_USUARIO" UNIQUE("EMAIL");        
ALTER TABLE "PUBLIC"."TELEFONO" ADD CONSTRAINT "PUBLIC"."FK_TELEFONO_USUARIO" FOREIGN KEY("USUARIO_ID") REFERENCES "PUBLIC"."USUARIO"("ID") NOCHECK;  
