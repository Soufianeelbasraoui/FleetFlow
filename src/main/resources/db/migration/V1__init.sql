CREATE TABLE chauffeur
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    nom          VARCHAR(255) NULL,
    telephone    VARCHAR(255) NULL,
    license_type VARCHAR(255) NULL,
    available    BIT(1) NULL,
    CONSTRAINT pk_chauffeur PRIMARY KEY (id)
);
CREATE TABLE client
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    nom       VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    telephone VARCHAR(255) NULL,
    ville     VARCHAR(255) NULL,
    CONSTRAINT pk_client PRIMARY KEY (id)
);

CREATE TABLE livraison
(
    id                  BIGINT AUTO_INCREMENT NOT NULL,
    date_livraison      date NULL,
    adresse_depart      VARCHAR(255) NULL,
    adresse_destination VARCHAR(255) NULL,
    statut              VARCHAR(255) NULL,
    client_id           BIGINT NULL,
    chauffeur_id        BIGINT NULL,
    vehicule_id         BIGINT NULL,
    CONSTRAINT pk_livraison PRIMARY KEY (id)
);

CREATE TABLE vehicule
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    matricule       VARCHAR(255) NULL,
    type_vehicule   VARCHAR(255) NULL,
    capacite        INT NOT NULL,
    statut_vehicule VARCHAR(255) NULL,
    permis_type     VARCHAR(255) NULL,
    disponible      BIT(1) NULL,
    CONSTRAINT pk_vehicule PRIMARY KEY (id)
);
