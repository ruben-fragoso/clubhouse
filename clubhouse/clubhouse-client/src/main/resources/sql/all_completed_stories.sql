-- View: public.all_completed_stories

-- DROP VIEW public.all_completed_stories;

CREATE OR REPLACE VIEW public.all_completed_stories
 AS
 SELECT st.storyid,
    st.estimate,
    cg.newvalue AS item_state,
    cg.created
   FROM changes cg
     JOIN stories st ON cg.storyid = st.storyid
  WHERE cg.changetype::text = 'workflow_state_id'::text AND cg.newvalue::text = 'Completed'::text;

ALTER TABLE public.all_completed_stories
    OWNER TO postgres;

