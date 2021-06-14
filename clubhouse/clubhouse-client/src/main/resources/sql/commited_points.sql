-- View: public.committed_points

-- DROP VIEW public.committed_points;

CREATE OR REPLACE VIEW public.committed_points
 AS
 SELECT st.estimate,
    st.name,
    st.storyid,
    sabt.iterationsid
   FROM stories st
     JOIN stories_added_before_start sabt ON st.storyid = sabt.storyid;

ALTER TABLE public.committed_points
    OWNER TO clubhouse;

