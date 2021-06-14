-- View: public.added_points

-- DROP VIEW public.added_points;

CREATE OR REPLACE VIEW public.added_points
 AS
 SELECT st.estimate,
    st.name,
    st.storyid,
    sabt.iterationsid
   FROM stories st
     JOIN stories_added_during_sprint sabt ON st.storyid = sabt.storyid;

ALTER TABLE public.added_points
    OWNER TO clubhouse;

