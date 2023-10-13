--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-10-13 15:29:03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 843 (class 1247 OID 16457)
-- Name: sport_type; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.sport_type AS ENUM (
    'Football',
    'Basketball'
);


ALTER TYPE public.sport_type OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16461)
-- Name: match_odds; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.match_odds (
    id integer NOT NULL,
    match_id integer NOT NULL,
    specifier character varying,
    odd double precision
);


ALTER TABLE public.match_odds OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16466)
-- Name: MatchOdds_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."MatchOdds_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."MatchOdds_id_seq" OWNER TO postgres;

--
-- TOC entry 4858 (class 0 OID 0)
-- Dependencies: 216
-- Name: MatchOdds_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."MatchOdds_id_seq" OWNED BY public.match_odds.id;


--
-- TOC entry 217 (class 1259 OID 16467)
-- Name: match; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.match (
    id integer NOT NULL,
    description character varying(50) DEFAULT NULL::character varying,
    match_date date,
    match_time time without time zone,
    team_a character varying(50) DEFAULT NULL::character varying,
    team_b character varying(50) DEFAULT NULL::character varying,
    sport public.sport_type
);


ALTER TABLE public.match OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16473)
-- Name: Match_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Match_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public."Match_id_seq" OWNER TO postgres;

--
-- TOC entry 4859 (class 0 OID 0)
-- Dependencies: 218
-- Name: Match_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Match_id_seq" OWNED BY public.match.id;


--
-- TOC entry 4697 (class 2604 OID 16485)
-- Name: match id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match ALTER COLUMN id SET DEFAULT nextval('public."Match_id_seq"'::regclass);


--
-- TOC entry 4696 (class 2604 OID 16486)
-- Name: match_odds id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match_odds ALTER COLUMN id SET DEFAULT nextval('public."MatchOdds_id_seq"'::regclass);


--
-- TOC entry 4851 (class 0 OID 16467)
-- Dependencies: 217
-- Data for Name: match; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.match (id, description, match_date, match_time, team_a, team_b, sport) FROM stdin;
17	Championship	2023-10-21	15:24:00	PAOK	PAO	Basketball
5	EuroLeague	2023-10-30	19:21:00	Celtic	Machester	Football
\.


--
-- TOC entry 4849 (class 0 OID 16461)
-- Dependencies: 215
-- Data for Name: match_odds; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.match_odds (id, match_id, specifier, odd) FROM stdin;
4	5	X	1.5
5	5	12	1.6
6	5	13	1.6
18	5	23	1.1
19	17	X	1.5
20	17	32	1.05
\.


--
-- TOC entry 4860 (class 0 OID 0)
-- Dependencies: 216
-- Name: MatchOdds_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."MatchOdds_id_seq"', 20, true);


--
-- TOC entry 4861 (class 0 OID 0)
-- Dependencies: 218
-- Name: Match_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Match_id_seq"', 17, true);


--
-- TOC entry 4702 (class 2606 OID 16477)
-- Name: match_odds MatchOdds_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match_odds
    ADD CONSTRAINT "MatchOdds_pkey" PRIMARY KEY (id);


--
-- TOC entry 4704 (class 2606 OID 16479)
-- Name: match Match_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match
    ADD CONSTRAINT "Match_pkey" PRIMARY KEY (id);


--
-- TOC entry 4705 (class 2606 OID 16480)
-- Name: match_odds MatchOdds_Match_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.match_odds
    ADD CONSTRAINT "MatchOdds_Match_id_fk" FOREIGN KEY (match_id) REFERENCES public.match(id);


-- Completed on 2023-10-13 15:29:03

--
-- PostgreSQL database dump complete
--

