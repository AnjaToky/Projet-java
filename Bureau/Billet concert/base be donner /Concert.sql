-- Création de la base de données
CREATE DATABASE gestion_concerts;
USE gestion_concerts;

-- Table: utilisateur
CREATE TABLE utilisateur (
    id_utilisateur INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    date_inscription DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Table: concert
CREATE TABLE concert (
    id_concert INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(200) NOT NULL,
    artiste VARCHAR(200) NOT NULL,
    date_concert DATETIME NOT NULL,
    lieu VARCHAR(255) NOT NULL,
    prix_par_billet DECIMAL(10, 2) NOT NULL,
    nombre_places INT NOT NULL
);

-- Table: reservation
CREATE TABLE reservation (
    id_reservation INT AUTO_INCREMENT PRIMARY KEY,
    id_utilisateur INT NOT NULL,
    id_concert INT NOT NULL,
    date_reservation DATETIME DEFAULT CURRENT_TIMESTAMP,
    statut ENUM('CONFIRMEE', 'ANNULEE') DEFAULT 'CONFIRMEE',
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id_utilisateur),
    FOREIGN KEY (id_concert) REFERENCES concert(id_concert)
);

-- Table: billet
CREATE TABLE billet (
    id_billet INT AUTO_INCREMENT PRIMARY KEY,
    id_reservation INT NOT NULL,
    code_billet VARCHAR(50) UNIQUE NOT NULL,
    statut ENUM('VALIDE', 'UTILISE', 'ANNULE') DEFAULT 'VALIDE',
    FOREIGN KEY (id_reservation) REFERENCES reservation(id_reservation)
);

-- Table: payement
CREATE TABLE payement (
    id_payement INT AUTO_INCREMENT PRIMARY KEY,
    id_reservation INT NOT NULL,
    montant DECIMAL(10, 2) NOT NULL,
    date_payement DATETIME DEFAULT CURRENT_TIMESTAMP,
    methode ENUM('CARTE', 'PAYPAL', 'VIREMENT') NOT NULL,
    statut ENUM('SUCCES', 'ECHEC') DEFAULT 'SUCCES',
    FOREIGN KEY (id_reservation) REFERENCES reservation(id_reservation)
);
