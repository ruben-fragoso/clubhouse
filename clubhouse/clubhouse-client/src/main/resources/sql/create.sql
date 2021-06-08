CREATE TABLE IF NOT EXISTS public.iterations(id uuid NOT NULL,enddate timestamp without time zone,iterationsid integer,name character varying(255) COLLATE pg_catalog."default",startdate timestamp without time zone,CONSTRAINT iterations_pkey PRIMARY KEY (id)) TABLESPACE pg_default;
ALTER TABLE public.iterations OWNER to clubhouse;
CREATE TABLE IF NOT EXISTS public.projects(id uuid NOT NULL,name character varying(255) COLLATE pg_catalog."default",project_id integer,CONSTRAINT projects_pkey PRIMARY KEY (id)) TABLESPACE pg_default;
ALTER TABLE public.projects OWNER to clubhouse;

