-- View: public.any_added_story

-- DROP VIEW public.any_added_story;

CREATE OR REPLACE VIEW public.any_added_story
 AS
 SELECT st.storyid,
    st.estimate,
    cg.newvalue AS iterationsid,
    cg.created
   FROM changes cg
     JOIN stories st ON cg.storyid = st.storyid
  WHERE cg.changetype::text = 'iteration'::text AND cg.newvalue IS NOT NULL;

ALTER TABLE public.any_added_story
    OWNER TO clubhouse;

