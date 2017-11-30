
USE NOMINA;
GO
IF OBJECT_ID(N'dbo.ufnGetTransactionInformation',N'TF') IS NOT NULL
	DROP FUNCTION dbo.ufnGetTransactionInformation;
GO
CREATE FUNCTION dbo.ufnGetTransactionInformation(@DateStart Date = NULL, @DateEnd Date = NULL)
RETURNS @retTransaccionInformation TABLE
(
	--Columnas retornadas por la función
	Id_Empleado int NULL
	,Credito_Nomina float NULL
	,Debito_Empleado float NULL
	,Debito_Deduccion float NULL
	,Cuenta_Empleado varchar(25) NULL
	,Cuenta_Nomina varchar(25) NULL
)
AS

BEGIN

	INSERT INTO @retTransaccionInformation

	select Id_Empleado, Credito_Nomina, (Credito_Nomina - Credito_Empleado) as Debito_Empleado, (Credito_Empleado) as Debito_Deduccion, DT_TR.Cuenta_Empleado, DT_TR.Cuenta_Nomina  from 

	(SELECT EM.Id as Id_Empleado, Em.Nombre, TR.Tipo_Transaccion, IIF( Exists (Select SUM(TR.Monto) where TR.Tipo_Transaccion = 'INGRESO'),(Select SUM(TR.Monto) where TR.Tipo_Transaccion = 'INGRESO'),0) as Credito_Nomina, IIF( exists (Select SUM(TR.Monto) where TR.Tipo_Transaccion = 'DEDUCCION'),(Select SUM(TR.Monto) where TR.Tipo_Transaccion = 'DEDUCCION'),0) as Credito_Empleado, EM.Cuenta as Cuenta_Empleado, NM.Cuenta as Cuenta_Nomina FROM TRANSACCION AS TR
	INNER JOIN EMPLEADO AS EM ON TR.Id_Empleado = EM.Id
	INNER JOIN NOMINA AS  NM ON EM.Id_Nomina = NM.Id
	WHERE	TR.Fecha >=  (SELECT IIF(@DateStart <> '',@DateStart,(SELECT MIN(FECHA) FROM TRANSACCION)))
			AND TR.Fecha <=  (SELECT IIF(@DateEnd <> '',@DateEnd,(SELECT MAX(FECHA) FROM TRANSACCION)))
	GROUP BY EM.Id, Em.Nombre, TR.Tipo_Transaccion, EM.Cuenta, NM.Cuenta
	) as DT_TR;

	RETURN;
END;



GO




USE NOMINA;
GO
IF OBJECT_ID(N'dbo.ufnGetAccountingEntryInformation',N'TF') IS NOT NULL
	DROP FUNCTION dbo.ufnGetAccountingEntryInformation;
GO
CREATE FUNCTION dbo.ufnGetAccountingEntryInformation(@DateStart Date = NULL, @DateEnd Date = NULL)
RETURNS @retufnGetAccountingEntryInformation TABLE
(
	--Columnas retornadas por la función
	Cuenta varchar(25) NULL
	,Tipo_Movimiento varchar(25) NULL
	,Monto varchar(25) NULL
	,Fecha Date NULL
)
AS

BEGIN

	INSERT INTO @retufnGetAccountingEntryInformation
	SELECT (Cuenta_Nomina) AS Cuenta, ('CR') AS Tipo_Movimiento,  (SUM(Credito_Nomina)) AS Monto, (GETDATE()) as Fecha FROM ufnGetTransactionInformation(@DateStart,@DateEnd) GROUP BY Cuenta_Nomina
	UNION ALL
	SELECT (Cuenta_Nomina) as Cuenta, ('DB') AS Tipo_Movimiento, (SUM(Debito_Deduccion)) AS Monto, (GETDATE()) as Fecha FROM ufnGetTransactionInformation(@DateStart,@DateEnd) GROUP BY Cuenta_Nomina
	UNION ALL
	SELECT (Cuenta_Empleado) as Cuenta, ('DB') AS Tipo_Movimiento, (SUM(Debito_Empleado)) AS Monto, (GETDATE()) as Fecha FROM ufnGetTransactionInformation(@DateStart,@DateEnd) GROUP BY Cuenta_Empleado
	RETURN;
END;

go
SELECT * FROM ufnGetAccountingEntryInformation('','')