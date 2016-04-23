CREATE TABLESPACE libertad_Data
  DATAFILE 'C:\OracleApp\oradata\dbpqlibertad\libertad_Data01.dbf'
  SIZE 50M
  REUSE
  AUTOEXTEND ON
  NEXT 512k
  MAXSIZE 200M;

-- PE: INDEX

CREATE TABLESPACE libertad_Indexes
  DATAFILE 'C:\OracleApp\oradata\dbpqlibertad\libertad_Indexes01.dbf'
  SIZE 10M
  REUSE
  AUTOEXTEND ON
  NEXT 512k
  MAXSIZE 200M;

CREATE USER libertadAdmin
  IDENTIFIED BY libertadAdmin123
  DEFAULT TABLESPACE libertad_Data
  TEMPORARY TABLESPACE temp
  QUOTA UNLIMITED ON libertad_Data
  QUOTA UNLIMITED ON libertad_Indexes;

GRANT CONNECT TO libertadAdmin;
GRANT CREATE TABLE TO libertadAdmin;
GRANT DEBUG CONNECT SESSION TO libertadAdmin;
--======================================== Java Users
CREATE PROFILE clientUser LIMIT
    SESSIONS_PER_USER 1
    IDLE_TIME UNLIMITED
    CONNECT_TIME UNLIMITED
    FAILED_LOGIN_ATTEMPTS UNLIMITED;

CREATE USER libertadDemoUser
  IDENTIFIED BY user123
  PROFILE clientUser;

GRANT CREATE SESSION TO libertadDemoUser;
