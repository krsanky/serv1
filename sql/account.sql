CREATE TABLE account (                                                                     
    id SERIAL PRIMARY KEY,
    password character varying(512) NOT NULL,
    is_superuser boolean,                                       
    username character varying(150) NOT NULL UNIQUE,
    first_name character varying(30),
    last_name character varying(30),
    email character varying(254),
    is_staff boolean,
    is_active boolean,
    timezone character varying(128) default 'America/New_York' 
);
