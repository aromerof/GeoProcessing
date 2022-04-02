CREATE EXTENSION IF NOT EXISTS postgis;

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
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION trigger_calculate_project_area()
RETURNS TRIGGER AS
$BODY$
    BEGIN
        NEW.area = round((ST_Area(NEW.aoi::geography) / 1000000)::numeric, 2);
        RETURN NEW;
    END;
$BODY$
LANGUAGE plpgsql;