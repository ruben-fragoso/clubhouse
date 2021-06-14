-- View: public.any_removed_story

-- DROP VIEW public.any_removed_story;

CREATE OR REPLACE VIEW public.any_removed_story
 AS
 SELECT st.storyid,
    st.estimate,
    cg.newvalue AS iterationsid,
    cg.created
   FROM changes cg
     JOIN stories st ON cg.storyid = st.storyid
  WHERE cg.changetype::text = 'iteration'::text AND cg.newvalue IS NULL;

ALTER TABLE public.any_removed_story
    OWNER TO clubhouse;

1LL7lQveg0