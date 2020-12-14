--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2020-12-14 10:30:01

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
-- TOC entry 203 (class 1259 OID 24795)
-- Name: _address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public._address (
    id integer NOT NULL,
    _number character varying(10) NOT NULL,
    _street character varying(50) NOT NULL,
    _zipcode character varying(5) NOT NULL,
    _city character varying(30) NOT NULL
);


ALTER TABLE public._address OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24793)
-- Name: _address_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public._address_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public._address_id_seq OWNER TO postgres;

--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 202
-- Name: _address_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public._address_id_seq OWNED BY public._address.id;


--
-- TOC entry 207 (class 1259 OID 24811)
-- Name: _burger; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public._burger (
    id integer NOT NULL,
    _label character varying(15),
    _price numeric(4,2)
);


ALTER TABLE public._burger OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24809)
-- Name: _burger_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public._burger_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public._burger_id_seq OWNER TO postgres;

--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 206
-- Name: _burger_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public._burger_id_seq OWNED BY public._burger.id;


--
-- TOC entry 205 (class 1259 OID 24803)
-- Name: _order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public._order (
    id integer NOT NULL,
    user_id integer NOT NULL,
    _beginning timestamp without time zone NOT NULL,
    _end timestamp without time zone NOT NULL,
    _total double precision NOT NULL,
    _state character varying(10) DEFAULT 'VALIDATED'::character varying NOT NULL
);


ALTER TABLE public._order OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24801)
-- Name: _order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public._order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public._order_id_seq OWNER TO postgres;

--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 204
-- Name: _order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public._order_id_seq OWNED BY public._order.id;


--
-- TOC entry 208 (class 1259 OID 24817)
-- Name: _order_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public._order_items (
    order_id integer NOT NULL,
    burger_id integer NOT NULL,
    _quantity integer NOT NULL
);


ALTER TABLE public._order_items OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24787)
-- Name: _user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public._user (
    id integer NOT NULL,
    _email character varying(50) NOT NULL,
    _firstname character varying(50) NOT NULL,
    _lastname character varying(50) NOT NULL,
    _phone character varying(10) NOT NULL,
    address_id integer NOT NULL,
    _password character varying(50) NOT NULL,
    _role character varying(10) DEFAULT 'USER'::character varying NOT NULL
);


ALTER TABLE public._user OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 24785)
-- Name: _user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public._user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public._user_id_seq OWNER TO postgres;

--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 200
-- Name: _user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public._user_id_seq OWNED BY public._user.id;


--
-- TOC entry 2874 (class 2604 OID 24798)
-- Name: _address id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._address ALTER COLUMN id SET DEFAULT nextval('public._address_id_seq'::regclass);


--
-- TOC entry 2877 (class 2604 OID 24814)
-- Name: _burger id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._burger ALTER COLUMN id SET DEFAULT nextval('public._burger_id_seq'::regclass);


--
-- TOC entry 2875 (class 2604 OID 24806)
-- Name: _order id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._order ALTER COLUMN id SET DEFAULT nextval('public._order_id_seq'::regclass);


--
-- TOC entry 2872 (class 2604 OID 24790)
-- Name: _user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._user ALTER COLUMN id SET DEFAULT nextval('public._user_id_seq'::regclass);


--
-- TOC entry 3025 (class 0 OID 24795)
-- Dependencies: 203
-- Data for Name: _address; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public._address (id, _number, _street, _zipcode, _city) VALUES (18, '9', 'rue de la Caserne St Martin ', '66000', 'Perpignan');
INSERT INTO public._address (id, _number, _street, _zipcode, _city) VALUES (19, '18', 'Avenue des champs', '13100', 'Aix en Provence');
INSERT INTO public._address (id, _number, _street, _zipcode, _city) VALUES (20, '25', 'Rue des prÃ¨s', '13100', 'Aix en Provence');
INSERT INTO public._address (id, _number, _street, _zipcode, _city) VALUES (21, '7', 'rue des PrÃ©s', '34000', 'Montpellier');


--
-- TOC entry 3029 (class 0 OID 24811)
-- Dependencies: 207
-- Data for Name: _burger; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public._burger (id, _label, _price) VALUES (1, 'Classique', 6.50);
INSERT INTO public._burger (id, _label, _price) VALUES (2, 'Veggie', 8.00);
INSERT INTO public._burger (id, _label, _price) VALUES (6, 'Montagnard', 10.00);
INSERT INTO public._burger (id, _label, _price) VALUES (7, 'Double Cheese', 9.00);
INSERT INTO public._burger (id, _label, _price) VALUES (8, 'Chicken', 7.50);
INSERT INTO public._burger (id, _label, _price) VALUES (9, 'Death Star', 11.00);


--
-- TOC entry 3027 (class 0 OID 24803)
-- Dependencies: 205
-- Data for Name: _order; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public._order (id, user_id, _beginning, _end, _total, _state) VALUES (4, 8, '2020-12-10 13:12:33.612', '2020-12-10 13:40:33.612', 13, 'VALIDATED');
INSERT INTO public._order (id, user_id, _beginning, _end, _total, _state) VALUES (3, 8, '2020-12-09 15:32:34.866', '2020-12-09 16:00:34.866', 27.5, 'ENDED');
INSERT INTO public._order (id, user_id, _beginning, _end, _total, _state) VALUES (2, 8, '2020-12-09 15:32:19.247', '2020-12-09 16:00:19.247', 22.5, 'ENDED');
INSERT INTO public._order (id, user_id, _beginning, _end, _total, _state) VALUES (9, 8, '2020-12-11 15:27:12.767', '2020-12-11 15:50:12.767', 8, 'VALIDATED');
INSERT INTO public._order (id, user_id, _beginning, _end, _total, _state) VALUES (10, 13, '2020-12-14 10:14:27.474', '2020-12-14 10:40:27.474', 16.5, 'ENDED');


--
-- TOC entry 3030 (class 0 OID 24817)
-- Dependencies: 208
-- Data for Name: _order_items; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public._order_items (order_id, burger_id, _quantity) VALUES (2, 1, 1);
INSERT INTO public._order_items (order_id, burger_id, _quantity) VALUES (2, 2, 2);
INSERT INTO public._order_items (order_id, burger_id, _quantity) VALUES (3, 1, 3);
INSERT INTO public._order_items (order_id, burger_id, _quantity) VALUES (3, 2, 1);
INSERT INTO public._order_items (order_id, burger_id, _quantity) VALUES (4, 1, 2);
INSERT INTO public._order_items (order_id, burger_id, _quantity) VALUES (9, 2, 1);
INSERT INTO public._order_items (order_id, burger_id, _quantity) VALUES (10, 1, 1);
INSERT INTO public._order_items (order_id, burger_id, _quantity) VALUES (10, 6, 1);


--
-- TOC entry 3023 (class 0 OID 24787)
-- Dependencies: 201
-- Data for Name: _user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public._user (id, _email, _firstname, _lastname, _phone, address_id, _password, _role) VALUES (8, 'mexas66@gmail.com', 'Mehdi', 'Benmansour', '0768635616', 18, 'kingdomhell66', 'USER');
INSERT INTO public._user (id, _email, _firstname, _lastname, _phone, address_id, _password, _role) VALUES (10, 'admin@bigburger.fr', 'admin', 'admin', '0123456789', 18, 'admin', 'ADMIN');
INSERT INTO public._user (id, _email, _firstname, _lastname, _phone, address_id, _password, _role) VALUES (11, 'durant@bigburger.fr', 'Pierre', 'Durant', '0123654789', 19, 'durant', 'COOKER');
INSERT INTO public._user (id, _email, _firstname, _lastname, _phone, address_id, _password, _role) VALUES (12, 'dupont@bigburger.fr', 'Bob', 'Dupont', '0469257436', 20, 'dupond', 'DELIVERY');
INSERT INTO public._user (id, _email, _firstname, _lastname, _phone, address_id, _password, _role) VALUES (13, 'norris@hollywood.com', 'Norris', 'Chuck', '0987654321', 21, 'norris', 'USER');


--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 202
-- Name: _address_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public._address_id_seq', 21, true);


--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 206
-- Name: _burger_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public._burger_id_seq', 9, true);


--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 204
-- Name: _order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public._order_id_seq', 10, true);


--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 200
-- Name: _user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public._user_id_seq', 13, true);


--
-- TOC entry 2881 (class 2606 OID 24800)
-- Name: _address _address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._address
    ADD CONSTRAINT _address_pkey PRIMARY KEY (id);


--
-- TOC entry 2885 (class 2606 OID 24816)
-- Name: _burger _burger_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._burger
    ADD CONSTRAINT _burger_pkey PRIMARY KEY (id);


--
-- TOC entry 2887 (class 2606 OID 24831)
-- Name: _order_items _order_items_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._order_items
    ADD CONSTRAINT _order_items_pkey PRIMARY KEY (burger_id, order_id);


--
-- TOC entry 2883 (class 2606 OID 24808)
-- Name: _order _order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._order
    ADD CONSTRAINT _order_pkey PRIMARY KEY (id);


--
-- TOC entry 2879 (class 2606 OID 24792)
-- Name: _user _user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._user
    ADD CONSTRAINT _user_pkey PRIMARY KEY (id);


--
-- TOC entry 2891 (class 2606 OID 24837)
-- Name: _order_items _order_items_burger_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._order_items
    ADD CONSTRAINT _order_items_burger_id_fkey FOREIGN KEY (burger_id) REFERENCES public._burger(id);


--
-- TOC entry 2890 (class 2606 OID 24832)
-- Name: _order_items _order_items_order_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._order_items
    ADD CONSTRAINT _order_items_order_id_fkey FOREIGN KEY (order_id) REFERENCES public._order(id);


--
-- TOC entry 2889 (class 2606 OID 24825)
-- Name: _order _order_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._order
    ADD CONSTRAINT _order_user_id_fkey FOREIGN KEY (user_id) REFERENCES public._user(id);


--
-- TOC entry 2888 (class 2606 OID 24820)
-- Name: _user _user_address_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public._user
    ADD CONSTRAINT _user_address_id_fkey FOREIGN KEY (address_id) REFERENCES public._address(id);


-- Completed on 2020-12-14 10:30:02

--
-- PostgreSQL database dump complete
--

