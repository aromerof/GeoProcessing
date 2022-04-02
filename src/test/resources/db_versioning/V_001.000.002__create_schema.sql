CREATE TABLE setting (
    id_setting integer NOT NULL,
    name text NOT NULL,
    value text NOT NULL,

    CONSTRAINT setting_pkey PRIMARY KEY (id_setting),

    CONSTRAINT setting_name_unique UNIQUE (name)
);

CREATE SEQUENCE setting_id_setting_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

ALTER SEQUENCE setting_id_setting_seq OWNED BY setting.id_setting;

ALTER TABLE ONLY setting ALTER COLUMN id_setting SET DEFAULT nextval('setting_id_setting_seq'::regclass);


CREATE TABLE project (
    id_project integer NOT NULL,
    code text NOT NULL,
    country text,
    state text,
    city text,
    year integer,
    aoi geometry(MULTIPOLYGON, 4326) NOT NULL,
    area numeric,
    comment text,

    CONSTRAINT project_pkey PRIMARY KEY (id_project),

    CONSTRAINT project_code_unique UNIQUE (code)
);

CREATE SEQUENCE project_id_project_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

ALTER SEQUENCE project_id_project_seq OWNED BY project.id_project;

ALTER TABLE ONLY project ALTER COLUMN id_project SET DEFAULT nextval('project_id_project_seq'::regclass);

CREATE TRIGGER calculate_project_area BEFORE INSERT ON project FOR EACH ROW EXECUTE PROCEDURE trigger_calculate_project_area();


CREATE TABLE flight (
    id_flight integer NOT NULL,
    id_project integer NOT NULL,
    code text NOT NULL,
    flight_date timestamp without time zone,
    num_images integer,
    comment text,

    CONSTRAINT flight_pkey PRIMARY KEY (id_flight),

    CONSTRAINT flight_id_project_code_unique UNIQUE (id_project, code),

    CONSTRAINT flight_id_project_fkey FOREIGN KEY (id_project)
    REFERENCES project (id_project) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE SEQUENCE flight_id_flight_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

ALTER SEQUENCE flight_id_flight_seq OWNED BY flight.id_flight;

ALTER TABLE ONLY flight ALTER COLUMN id_flight SET DEFAULT nextval('flight_id_flight_seq'::regclass);


CREATE TABLE run (
    id_run integer NOT NULL,
    id_flight integer NOT NULL,
    code text NOT NULL,
    trajectory geometry(LINESTRING, 4326) NOT NULL,

    CONSTRAINT run_pkey PRIMARY KEY (id_run),

    CONSTRAINT run_id_flight_code_unique UNIQUE (id_flight, code),

    CONSTRAINT run_id_flight_fkey FOREIGN KEY (id_flight)
    REFERENCES flight (id_flight) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE SEQUENCE run_id_run_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

ALTER SEQUENCE run_id_run_seq OWNED BY run.id_run;

ALTER TABLE ONLY run ALTER COLUMN id_run SET DEFAULT nextval('run_id_run_seq'::regclass);


CREATE TABLE image (
    id_image integer NOT NULL,
    id_run integer NOT NULL,
    code text NOT NULL,
    captured_at timestamp without time zone,
    camera text NOT NULL,
    orientation text NOT NULL,
    shot geometry(POINT, 4326) NOT NULL,
    footprint geometry(POLYGON, 4326) NOT NULL,
    status integer NOT NULL,

    CONSTRAINT image_pkey PRIMARY KEY (id_image),

    CONSTRAINT image_id_run_code_unique UNIQUE (id_run, code),

    CONSTRAINT image_id_run_fkey FOREIGN KEY (id_run)
    REFERENCES run (id_run) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE SEQUENCE image_id_image_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

ALTER SEQUENCE image_id_image_seq OWNED BY image.id_image;

ALTER TABLE ONLY image ALTER COLUMN id_image SET DEFAULT nextval('image_id_image_seq'::regclass);