ALTER TABLE chauffeur
    ALTER COLUMN available SET DEFAULT TRUE;

ALTER TABLE vehicule
    ALTER COLUMN statut_vehicule SET DEFAULT 'AVAILABLE';

ALTER TABLE livraison
    ALTER COLUMN statut SET DEFAULT 'PENDING';


ALTER TABLE vehicule
    ADD CONSTRAINT chk_vehicule_capacite_positive
        CHECK (capacite > 0);

ALTER TABLE livraison
    ADD CONSTRAINT fk_livraison_client
        FOREIGN KEY (client_id)
            REFERENCES client(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE;

ALTER TABLE livraison
    ADD CONSTRAINT fk_livraison_chauffeur
        FOREIGN KEY (chauffeur_id)
            REFERENCES chauffeur(id)
            ON DELETE SET NULL
            ON UPDATE CASCADE;

ALTER TABLE livraison
    ADD CONSTRAINT fk_livraison_vehicule
        FOREIGN KEY (vehicule_id)
            REFERENCES vehicule(id)
            ON DELETE SET NULL
            ON UPDATE CASCADE;

