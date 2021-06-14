-- View: public.stories_added_before_start

-- DROP VIEW public.stories_added_before_start;

CREATE OR REPLACE VIEW public.stories_added_before_start
 AS
 SELECT cg.newvalue,
    cg.storyid,
    it.id,
    it.enddate,
    it.iterationsid,
    it.name,
    it.startdate
   FROM changes cg
     JOIN iterations it ON cg.newvalue::text = it.iterationsid::text
  WHERE cg.created < it.startdate
  ORDER BY cg.created;

ALTER TABLE public.stories_added_before_start
    OWNER TO clubhouse;

