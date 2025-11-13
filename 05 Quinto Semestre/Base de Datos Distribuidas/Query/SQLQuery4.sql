-- Copiar registros de la tabla SUCURSAL de la BD centralizada FITEC a la sede QUITO_SUR
USE QUITO_SUR;
SELECT *
INTO QUITO_SUR.dbo.SUCURSAL
FROM [DESKTOP-HSCPRKC].[FITEC].[dbo].[SUCURSAL];

-- Hacer que la columna IDSUCURSAL sea primary key ya que se ha copiado sin clave primaria 
ALTER TABLE SUCURSAL
ADD CONSTRAINT PK_SUCURSAL PRIMARY KEY (IDSUCURSAL);
-- Consulta
Select * from SUCURSAL





