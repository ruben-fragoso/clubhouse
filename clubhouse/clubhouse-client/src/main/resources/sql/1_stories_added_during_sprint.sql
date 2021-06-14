-- View: public.stories_added_during_sprint

-- DROP VIEW public.stories_added_during_sprint;

CREATE OR REPLACE VIEW public.stories_added_during_sprint
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
  WHERE cg.created > it.startdate AND cg.created < it.enddate
  ORDER BY cg.created;

ALTER TABLE public.stories_added_during_sprint
    OWNER TO clubhouse;

