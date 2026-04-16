
ALTER TABLE chauffeur MODIFY COLUMN available BOOLEAN DEFAULT TRUE;
ALTER TABLE vehicule MODIFY COLUMN statut_vehicule VARCHAR(255) DEFAULT 'AVAILABLE';

ALTER TABLE livraison MODIFY COLUMN statut VARCHAR(255) DEFAULT 'PENDING';

ALTER TABLE vehicule
    ADD CONSTRAINT chk_vehicule_capacite CHECK (capacite > 0);


ALTER TABLE livraison
    ADD CONSTRAINT fk_livraison_client
        FOREIGN KEY (client_id) REFERENCES client(id)
            ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE livraison
    ADD CONSTRAINT fk_livraison_chauffeur
        FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id)
            ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE livraison
    ADD CONSTRAINT fk_livraison_vehicule
        FOREIGN KEY (vehicule_id) REFERENCES vehicule(id)
            ON DELETE SET NULL ON UPDATE CASCADE;