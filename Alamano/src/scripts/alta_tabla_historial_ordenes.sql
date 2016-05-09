CREATE TABLE HISTORIAL_ORDENES(
	CREATE_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de Creación de la fila',
	UPDATE_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de modificación',
	UPDATE_USER VARCHAR(200) NOT NULL DEFAULT '' COMMENT 'Usuario que registro el cambio',
	ID_ORDEN INT UNSIGNED NOT NULL COMMENT 'Identificador de la orden',
	CODIGO_ESTADO VARCHAR(15) NOT NULL COMMENT 'Estado de la Orden',
	DESCRIPCION VARCHAR(150) NOT NULL COMMENT 'Descripción',
	FOREIGN KEY(ID_ORDEN) REFERENCES ORDEN(ID_ORDEN)
	FOREIGN KEY(CODIGO_ESTADO) REFERENCES ORDEN(CODIGO_ESTADO)
	);
	
ALTER TABLE HISTORIAL_ORDENES ADD INDEX (CODIGO_ESTADO);