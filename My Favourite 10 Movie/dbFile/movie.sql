--
-- PostgreSQL database dump
--

-- Dumped from database version 12.9 (Ubuntu 12.9-2.pgdg20.04+1)
-- Dumped by pg_dump version 14.1 (Ubuntu 14.1-2.pgdg20.04+1)

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: favourit; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.favourit (
    id integer NOT NULL,
    list_id integer
);


ALTER TABLE public.favourit OWNER TO postgres;

--
-- Name: favourit_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.favourit ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.favourit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: list; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.list (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    img character varying(220) NOT NULL,
    type character varying(20) NOT NULL
);


ALTER TABLE public.list OWNER TO postgres;

--
-- Name: suggest; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.suggest (
    id integer NOT NULL,
    list_id integer
);


ALTER TABLE public.suggest OWNER TO postgres;

--
-- Name: suggest_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.suggest ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.suggest_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: favourit; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.favourit (id, list_id) FROM stdin;
\.


--
-- Data for Name: list; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.list (id, name, img, type) FROM stdin;
\.


--
-- Data for Name: suggest; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.suggest (id, list_id) FROM stdin;
\.


--
-- Name: favourit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.favourit_id_seq', 1, false);


--
-- Name: suggest_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.suggest_id_seq', 1, false);


--
-- Name: favourit favourit_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favourit
    ADD CONSTRAINT favourit_pkey PRIMARY KEY (id);


--
-- Name: list list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.list
    ADD CONSTRAINT list_pkey PRIMARY KEY (id);


--
-- Name: suggest suggest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suggest
    ADD CONSTRAINT suggest_pkey PRIMARY KEY (id);


--
-- Name: favourit fk_list; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favourit
    ADD CONSTRAINT fk_list FOREIGN KEY (list_id) REFERENCES public.list(id);


--
-- Name: suggest fk_list; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suggest
    ADD CONSTRAINT fk_list FOREIGN KEY (list_id) REFERENCES public.list(id);


--
-- PostgreSQL database dump complete
--

