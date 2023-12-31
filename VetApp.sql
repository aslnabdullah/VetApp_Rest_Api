PGDMP         	                {            vetApp    13.13    13.13 4    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    25006    vetApp    DATABASE     f   CREATE DATABASE "vetApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_T�rkiye.1254';
    DROP DATABASE "vetApp";
                postgres    false            �            1259    25541    animals    TABLE     �  CREATE TABLE public.animals (
    date_of_birth date NOT NULL,
    customer_id bigint,
    id bigint NOT NULL,
    breed character varying(255) NOT NULL,
    colour character varying(255) NOT NULL,
    gender character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    species character varying(255) NOT NULL,
    CONSTRAINT animals_gender_check CHECK (((gender)::text = ANY ((ARRAY['MALE'::character varying, 'FEMALE'::character varying])::text[])))
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    25539    animals_id_seq    SEQUENCE     w   CREATE SEQUENCE public.animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.animals_id_seq;
       public          postgres    false    201            �           0    0    animals_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.animals_id_seq OWNED BY public.animals.id;
          public          postgres    false    200            �            1259    25553    appointments    TABLE     �   CREATE TABLE public.appointments (
    animal_id bigint,
    appointment_date timestamp(6) without time zone NOT NULL,
    doctor_id bigint,
    id bigint NOT NULL
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    25551    appointments_id_seq    SEQUENCE     |   CREATE SEQUENCE public.appointments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.appointments_id_seq;
       public          postgres    false    203            �           0    0    appointments_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.appointments_id_seq OWNED BY public.appointments.id;
          public          postgres    false    202            �            1259    25561    available_date    TABLE     w   CREATE TABLE public.available_date (
    available_date date NOT NULL,
    doctor_id bigint,
    id bigint NOT NULL
);
 "   DROP TABLE public.available_date;
       public         heap    postgres    false            �            1259    25559    available_date_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.available_date_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.available_date_id_seq;
       public          postgres    false    205            �           0    0    available_date_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.available_date_id_seq OWNED BY public.available_date.id;
          public          postgres    false    204            �            1259    25569 	   customers    TABLE       CREATE TABLE public.customers (
    id bigint NOT NULL,
    adress character varying(255) NOT NULL,
    city character varying(255),
    mail character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    25567    customers_id_seq    SEQUENCE     y   CREATE SEQUENCE public.customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.customers_id_seq;
       public          postgres    false    207            �           0    0    customers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.customers_id_seq OWNED BY public.customers.id;
          public          postgres    false    206            �            1259    25582    doctors    TABLE       CREATE TABLE public.doctors (
    id bigint NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    25580    doctors_id_seq    SEQUENCE     w   CREATE SEQUENCE public.doctors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.doctors_id_seq;
       public          postgres    false    209            �           0    0    doctors_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.doctors_id_seq OWNED BY public.doctors.id;
          public          postgres    false    208            �            1259    25593    vaccines    TABLE     �   CREATE TABLE public.vaccines (
    protection_finish_date date NOT NULL,
    protection_start_date date NOT NULL,
    animal_id bigint,
    id bigint NOT NULL,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    25591    vaccines_id_seq    SEQUENCE     x   CREATE SEQUENCE public.vaccines_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.vaccines_id_seq;
       public          postgres    false    211            �           0    0    vaccines_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.vaccines_id_seq OWNED BY public.vaccines.id;
          public          postgres    false    210            D           2604    25544 
   animals id    DEFAULT     h   ALTER TABLE ONLY public.animals ALTER COLUMN id SET DEFAULT nextval('public.animals_id_seq'::regclass);
 9   ALTER TABLE public.animals ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    201    200    201            F           2604    25556    appointments id    DEFAULT     r   ALTER TABLE ONLY public.appointments ALTER COLUMN id SET DEFAULT nextval('public.appointments_id_seq'::regclass);
 >   ALTER TABLE public.appointments ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            G           2604    25564    available_date id    DEFAULT     v   ALTER TABLE ONLY public.available_date ALTER COLUMN id SET DEFAULT nextval('public.available_date_id_seq'::regclass);
 @   ALTER TABLE public.available_date ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    205    205            H           2604    25572    customers id    DEFAULT     l   ALTER TABLE ONLY public.customers ALTER COLUMN id SET DEFAULT nextval('public.customers_id_seq'::regclass);
 ;   ALTER TABLE public.customers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            I           2604    25585 
   doctors id    DEFAULT     h   ALTER TABLE ONLY public.doctors ALTER COLUMN id SET DEFAULT nextval('public.doctors_id_seq'::regclass);
 9   ALTER TABLE public.doctors ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208    209            J           2604    25596    vaccines id    DEFAULT     j   ALTER TABLE ONLY public.vaccines ALTER COLUMN id SET DEFAULT nextval('public.vaccines_id_seq'::regclass);
 :   ALTER TABLE public.vaccines ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            �          0    25541    animals 
   TABLE DATA           g   COPY public.animals (date_of_birth, customer_id, id, breed, colour, gender, name, species) FROM stdin;
    public          postgres    false    201   <       �          0    25553    appointments 
   TABLE DATA           R   COPY public.appointments (animal_id, appointment_date, doctor_id, id) FROM stdin;
    public          postgres    false    203   �<       �          0    25561    available_date 
   TABLE DATA           G   COPY public.available_date (available_date, doctor_id, id) FROM stdin;
    public          postgres    false    205   -=       �          0    25569 	   customers 
   TABLE DATA           H   COPY public.customers (id, adress, city, mail, name, phone) FROM stdin;
    public          postgres    false    207   |=       �          0    25582    doctors 
   TABLE DATA           G   COPY public.doctors (id, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    209   �>       �          0    25593    vaccines 
   TABLE DATA           l   COPY public.vaccines (protection_finish_date, protection_start_date, animal_id, id, code, name) FROM stdin;
    public          postgres    false    211   �?       �           0    0    animals_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.animals_id_seq', 5, true);
          public          postgres    false    200            �           0    0    appointments_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.appointments_id_seq', 5, true);
          public          postgres    false    202            �           0    0    available_date_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.available_date_id_seq', 5, true);
          public          postgres    false    204            �           0    0    customers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.customers_id_seq', 5, true);
          public          postgres    false    206            �           0    0    doctors_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.doctors_id_seq', 5, true);
          public          postgres    false    208            �           0    0    vaccines_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.vaccines_id_seq', 5, true);
          public          postgres    false    210            L           2606    25550    animals animals_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    201            N           2606    25558    appointments appointments_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    203            P           2606    25566 "   available_date available_date_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.available_date
    ADD CONSTRAINT available_date_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.available_date DROP CONSTRAINT available_date_pkey;
       public            postgres    false    205            R           2606    25579    customers customers_mail_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_mail_key UNIQUE (mail);
 F   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_mail_key;
       public            postgres    false    207            T           2606    25577    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    207            V           2606    25590    doctors doctors_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    209            X           2606    25601    vaccines vaccines_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    211            Z           2606    25607 (   appointments fk95vepu86o8syqtux9gkr71bhy    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk95vepu86o8syqtux9gkr71bhy FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk95vepu86o8syqtux9gkr71bhy;
       public          postgres    false    201    2892    203            Y           2606    25602 #   animals fkb36lt3kj4mrbdx5btxmp4j60n    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n FOREIGN KEY (customer_id) REFERENCES public.customers(id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n;
       public          postgres    false    207    201    2900            \           2606    25617 *   available_date fkbq44iqs91gghds83rs8xachaj    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_date
    ADD CONSTRAINT fkbq44iqs91gghds83rs8xachaj FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 T   ALTER TABLE ONLY public.available_date DROP CONSTRAINT fkbq44iqs91gghds83rs8xachaj;
       public          postgres    false    2902    209    205            ]           2606    25622 $   vaccines fkeasdy15b2kp5j4k13x2dfudqs    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs;
       public          postgres    false    211    201    2892            [           2606    25612 (   appointments fkmujeo4tymoo98cmf7uj3vsv76    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76 FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76;
       public          postgres    false    209    203    2902            �   �   x�-�1�0����/g�EDFMpQG�+l�@SJ�z�4�vy��$� �����{�@Yn�O�����I"�T���v�c�s�QÞ�	KB�P���!N[�?:��[3$*J�E���������z�܏VC�a����س5ڧ/vl�����.˲'�=_      �   U   x�-���0C�s<E���Rfa�9("�O~���p�[�r��{B!��Oc(ϖ�"�Ɨq)�%%1�ɝ)Gː�j)*����s x��      �   ?   x�-��	�0�޾]\l_B�.��&�R�b�+���6GE-z�ѷ�00�NƘ��=U���      �   <  x�U��n�0E��Wx��Hl�(R+�Z�R7q�ȏ�<*%�.�-�P��Nx����u��}�l�?<�|	)X����'h�cQ��T��&���sa�G*����o3�&���G���R�B�8��Z{���T'�����*�3H�c+ļdd_�u�t�-�������j4Ɓ`SH�?�E�fuw����C��zVo*�����@��-��g�����@�E��u%�v�K���o�ya��R�i�k@������^�a$�xD�[��o_���O�_��ǯƑ{��C#:���E;���H�XD�0x�A����4      �   &  x�]�Kn�0@��)����O�5P�B,�����$Sb�I�#�[�=X�Ѩ�g�����A�n�b��j�{�^��Wu�����Ί��n��d�>�vQv���xZzq&i~,�
�Ϸ��ř|O��@�>o��k������{f*��Q��,K�8��ȿx�c�A�Tk�*�?��-�hK]�����Em�O�?Iy�@F�C@��_���]�����Oh
L�g�-c�������[z���.����ݩG{я��׷�::��Df|R��<��d�a$?R�_q��      �   �   x�E��
AE��+��H�}N�����X٬:�X�,��_oF�4r������-(K[bml�^Sz�s@eU⊸7K���Q��^�n�x.R�������p�RL�!{�9��ҕX>a���YbUZ�5eXcX���VxX"�M,*G     