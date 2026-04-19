CREATE TABLE chauffeur (
                           id  BIGINT AUTO_INCREMENT NOT NULL,
                           nom   VARCHAR(255),
                           telephone VARCHAR(255),
                           license_type VARCHAR(255),
                           available BOOLEAN,
                           CONSTRAINT pk_chauffeur PRIMARY KEY (id)
);

CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT NOT NULL,
                        nom  VARCHAR(255),
                        email VARCHAR(255),
                        telephone VARCHAR(255),
                        ville  VARCHAR(255),
                        CONSTRAINT pk_client PRIMARY KEY (id)
);

CREATE TABLE vehicule (
                          id BIGINT AUTO_INCREMENT NOT NULL,
                          matricule VARCHAR(255),
                          type_vehicule VARCHAR(255),
                          capacite  INT NOT NULL,
                          statut_vehicule VARCHAR(255),
                          permis_type  VARCHAR(255),
                          disponible  BOOLEAN,
                          CONSTRAINT pk_vehicule PRIMARY KEY (id)
);

CREATE TABLE livraison (
                           id                   BIGINT AUTO_INCREMENT NOT NULL,
                           date_livraison       DATE,
                           adresse_depart       VARCHAR(255),
                           adresse_destination  VARCHAR(255),
                           statut               VARCHAR(255),
                           client_id            BIGINT,
                           chauffeur_id         BIGINT,
                           vehicule_id          BIGINT,
                           CONSTRAINT pk_livraison PRIMARY KEY (id)

);