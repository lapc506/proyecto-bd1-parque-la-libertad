CREATE OR REPLACE PROCEDURE insert_cuenta_usuario(usuario VARCHAR2,contrasena VARCHAR2,idEmpleado NUMBER) AS
BEGIN
INSERT INTO cuentausuario(id,usuario, contraseña, idempleado)
VALUES(S_CUENTAUSUARIO.NEXTVAL, usuario, contrasena, idempleado);
END;