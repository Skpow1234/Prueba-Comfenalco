-- Trigger para actualizar campos de auditoría en Comerciantes
CREATE
OR REPLACE TRIGGER trg_Comerciantes_Auditoria BEFORE
INSERT
    OR
UPDATE
    ON Comerciantes FOR EACH ROW BEGIN :NEW.FechaActualizacion := SYSDATE;

:NEW.Usuario := USER;

END;

/ -- Trigger para actualizar campos de auditoría en Establecimientos
CREATE
OR REPLACE TRIGGER trg_Establecimientos_Auditoria BEFORE
INSERT
    OR
UPDATE
    ON Establecimientos FOR EACH ROW BEGIN :NEW.FechaActualizacion := SYSDATE;

:NEW.Usuario := USER;

END;

/