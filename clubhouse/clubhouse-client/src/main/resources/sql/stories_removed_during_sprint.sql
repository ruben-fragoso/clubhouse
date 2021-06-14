-- View: public.stories_removed_during_sprint

-- DROP VIEW public.stories_removed_during_sprint;

CREATE OR REPLACE VIEW public.stories_removed_during_sprint
 AS
 SELECT cg.newvalue,
    cg.storyid,
    cg.created,
    it.id,
    it.iterationsid,
    it.name
   FROM changes cg
     JOIN iterations it ON cg.oldvalue::text = it.iterationsid::text
  WHERE cg.created < it.enddate AND cg.created > it.startdate
  ORDER BY cg.created;

ALTER TABLE public.stories_removed_during_sprint
    OWNER TO clubhouse;

