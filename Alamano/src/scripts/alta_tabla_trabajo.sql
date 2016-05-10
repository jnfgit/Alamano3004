CREATE TABLE TRABAJO(
	CREATE_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de Creaci�n de la fila',
	UPDATE_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de modificaci�n',
	UPDATE_USER VARCHAR(200) NOT NULL DEFAULT '' COMMENT 'Usuario que registro el cambio',
	ID_TRABAJO INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Identificador del trabajo',
	ID_SERVICIO INT UNSIGNED NOT NULL COMMENT 'Identificador del servicio',
	ID_PROVEEDOR INT UNSIGNED NOT NULL COMMENT 'Identificador del proveedor',
	PRECIO_HORA FLOAT(10,2) NOT NULL COMMENT 'El valor del precio final de la orden',
	COMISION FLOAT(2,2) NOT NULL COMMENT 'Comisi�n por el servicio',
	FECHA_INICIO DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha inicio',
	FECHA_FIN DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha fin',
	HORARIO_DISP_INI DECIMAL(2,2) UNSIGNED NOT NULL COMMENT 'Inicio del Horario Disponible',
	HORARIO_DISP_FIN DECIMAL(2,2) UNSIGNED NOT NULL COMMENT 'Fin del Horario Disponible',
	PRIMARY KEY (ID_TRABAJO),
	FOREIGN KEY(ID_SERVICIO) REFERENCES SERVICIO(ID_SERVICIO),
	FOREIGN KEY(ID_PROVEEDOR) REFERENCES PROVEEDOR(ID_PROVEEDOR)
	);
	
ALTER TABLE TRABAJO ADD INDEX (ID_SERVICIO);
ALTER TABLE TRABAJO ADD INDEX (ID_PROVEEDOR);