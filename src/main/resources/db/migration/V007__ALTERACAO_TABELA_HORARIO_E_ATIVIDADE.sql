ALTER TABLE HORARIO ADD COLUMN turno VARCHAR(11);

ALTER TABLE ATIVIDADE DROP COLUMN turno;
ALTER TABLE ATIVIDADE DROP COLUMN data;