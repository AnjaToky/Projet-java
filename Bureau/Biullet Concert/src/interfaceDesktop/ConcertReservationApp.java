package interfaceDesktop;

import java.awt.*;
import java.time.LocalDateTime;
import javax.swing.*;
import concert.ConcertDAO;

public class ConcertReservationApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConcertReservationApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Réservation de Billets de Concert");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        JLabel welcomeLabel = new JLabel("Bienvenue sur le site de réservation de billets de concert", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(welcomeLabel);

        JButton viewConcertsButton = new JButton("Voir les concerts disponibles");
        JButton bookTicketButton = new JButton("Réserver un billet");
        JButton userInfoButton = new JButton("Afficher les informations de l'utilisateur");
        JButton exitButton = new JButton("Quitter");

        panel.add(viewConcertsButton);
        panel.add(bookTicketButton);
        panel.add(userInfoButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Actions des boutons
        viewConcertsButton.addActionListener(e -> viewConcerts());
        bookTicketButton.addActionListener(e -> bookTicket());
        userInfoButton.addActionListener(e -> showUserInfo());
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void viewConcerts() {
        JFrame frame = new JFrame("Concerts Disponibles");
        frame.setSize(400, 300);

        ConcertDAO concert  = new ConcertDAO();
        
        JTextArea concertsTextArea = new JTextArea();
        concertsTextArea.setEditable(false);

        // Simuler l'affichage des concerts depuis ConcertDAO
        //concertsTextArea.setText("Concert 1: Rock Night\nConcert 2: Jazz Evening\nConcert 3: Classical Morning\n...");

        frame.add(new JScrollPane(concert.afficheConcert()));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void bookTicket() {
        JFrame frame = new JFrame("Réserver un Billet");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(8, 2, 10, 10));

        JLabel nameLabel = new JLabel("Nom:");
        JTextField nameField = new JTextField();
        JLabel firstNameLabel = new JLabel("Prénom:");
        JTextField firstNameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Mot de passe:");
        JPasswordField passwordField = new JPasswordField();
        JLabel concertIdLabel = new JLabel("ID du Concert:");
        JTextField concertIdField = new JTextField();

        JButton reserveButton = new JButton("Réserver");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(firstNameLabel);
        frame.add(firstNameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(concertIdLabel);
        frame.add(concertIdField);
        frame.add(new JLabel());
        frame.add(reserveButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        reserveButton.addActionListener(e -> {
            String name = nameField.getText();
            String firstName = firstNameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String concertId = concertIdField.getText();

            if (name.isEmpty() || firstName.isEmpty() || email.isEmpty() || password.isEmpty() || concertId.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                LocalDateTime now = LocalDateTime.now();
                // Logique pour réserver un billet via DAO (simulé ici)
                JOptionPane.showMessageDialog(frame, "Billet réservé avec succès pour le concert ID " + concertId + "!", "Succès", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            }
        });
    }

    private void showUserInfo() {
        JFrame frame = new JFrame("Informations de l'Utilisateur");
        frame.setSize(400, 300);

        JTextArea userInfoTextArea = new JTextArea();
        userInfoTextArea.setEditable(false);

        // Simuler l'affichage des informations utilisateur depuis UtilisateurDAO
        userInfoTextArea.setText("Nom: Dupont\nPrénom: Jean\nEmail: jean.dupont@example.com\nDate d'inscription: 2023-12-01\n...");

        frame.add(new JScrollPane(userInfoTextArea));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
