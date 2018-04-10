-- Table: public.user_nubicall

-- DROP TABLE public.user_nubicall;

CREATE TABLE public.user_nubicall
(
  username character varying(50) NOT NULL, -- column username specifies a nickname of a user
  firstname character varying(50), -- User's first name
  lastname character varying(50), -- User's lastname
  email character varying(50), -- User's email
  password character varying(10), -- User's password
  phone character varying(20), -- User's Phone
  userstatus character varying(7), -- A status from a user
  CONSTRAINT user_pkey PRIMARY KEY (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.user_nubicall
  OWNER TO postgres;
COMMENT ON COLUMN public.user_nubicall.username IS 'column username specifies a nickname of a user';
COMMENT ON COLUMN public.user_nubicall.firstname IS 'User''s first name';
COMMENT ON COLUMN public.user_nubicall.lastname IS 'User''s lastname';
COMMENT ON COLUMN public.user_nubicall.email IS 'User''s email';
COMMENT ON COLUMN public.user_nubicall.password IS 'User''s password ';
COMMENT ON COLUMN public.user_nubicall.phone IS 'User''s Phone';
COMMENT ON COLUMN public.user_nubicall.userstatus IS 'A status from a user';

