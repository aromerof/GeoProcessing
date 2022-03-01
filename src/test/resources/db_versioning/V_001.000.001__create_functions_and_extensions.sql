CREATE OR REPLACE FUNCTION now_utc()
RETURNS timestamp without time zone AS
$BODY$
    DECLARE
        OUTPUT_TIMESTAMP timestamp without time zone;
    BEGIN
        SELECT NOW() AT TIME ZONE 'UTC' INTO OUTPUT_TIMESTAMP;
        RETURN OUTPUT_TIMESTAMP;
    END;
$BODY$
LANGUAGE plpgsql VOLATILE
COST 100;

CREATE EXTENSION IF NOT EXISTS postgis;