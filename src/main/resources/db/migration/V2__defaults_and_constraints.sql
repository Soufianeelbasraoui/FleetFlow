ALTER TABLE chauffeur
    MODIFY available TINYINT(1) DEFAULT 1;

ALTER TABLE vehicule
    MODIFY statut_vehicule VARCHAR(255) DEFAULT 'AVAILABLE';

ALTER TABLE livraison
    MODIFY statut VARCHAR(255) DEFAULT 'PENDING';

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