/*CREATE TABLE AnioLectivo (id NUMBER(4) PRIMARY KEY, numeroAnio NUMBER(4)
    CONSTRAINT anioLectivo_numero_nn NOT NULL);

CREATE TABLE Semana(id NUMBER(8), diaInicial DATE
    DEFAULT SYSDATE CONSTRAINT Semana_diaInicial_nn NOT NULL,
    idAnioLectivo NUMBER(4));
    
ALTER TABLE Semana ADD
    CONSTRAINT pk_Semana PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;
    
ALTER TABLE Semana ADD
    CONSTRAINT fk_Semana_Anio FOREIGN KEY (idAnioLectivo)
    REFERENCES AnioLectivo(id);

CREATE TABLE TipoPeriodo(
  id NUMBER(3),
  descripcion VARCHAR2(30)
);

ALTER TABLE TipoPeriodo
  ADD CONSTRAINT pk_TipoPeriodo PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;   */

CREATE TABLE PERIODO(id NUMBER(20),
    --idSemanaInicial NUMBER(8),
    --idSemanaFinal NUMBER(8),
    --idTipoPeriodo NUMBER(3));
    idFechaInicial DATE,
    idFechaFinal DATE);
    
ALTER TABLE PERIODO
  ADD CONSTRAINT pk_Periodo PRIMARY KEY (id)
    USING INDEX TABLESPACE libertad_Indexes;
    
/*ALTER TABLE PERIODO ADD
    CONSTRAINT fk_Periodo_semanaInicial FOREIGN KEY (idSemanaInicial)
    REFERENCES Semana(id);
    
ALTER TABLE PERIODO ADD
    CONSTRAINT fk_Periodo_semanaFinal FOREIGN KEY (idSemanaFinal)
    REFERENCES Semana(id);
    
ALTER TABLE PERIODO ADD
    CONSTRAINT fk_Periodo_tipo FOREIGN KEY (idTipoPeriodo)
    REFERENCES TipoPeriodo(id);*/

    

    
