import aeroport.Compagnie;
import aeroport.Vol;
import aeroport.Aeroport;
import reservation.Reservation;
import reservation.Passager;
import reservation.PieceIdentite;
import reservation.Client;
import reservation.InfoBanquaire;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Start {

    public static void main(String[] args){
        Vol volFinal = new Vol();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String dd = "21/10/2020 13:00";
        String da = "21/10/2020 15:00";
        try {
            Date dateDepart = format.parse(dd);
            Date dateArrivee = format.parse(da);
            ZonedDateTime zonedDateDepart = ZonedDateTime.ofInstant(dateDepart.toInstant(), ZoneId.systemDefault());
            ZonedDateTime zonedDateArrivee = ZonedDateTime.ofInstant(dateArrivee.toInstant(), ZoneId.systemDefault());
            volFinal.setDateDepart(zonedDateDepart);
            volFinal.setDateArrivee(zonedDateArrivee);
        } catch (Exception e){
            throw new RuntimeException("Unable to format to date");
        }

        System.out.println(volFinal.getDateArrivee());
        System.out.println(volFinal.obtenirDuree().toString().substring(2));

        Vol vol = new Vol();
        vol.setNumero("abc1");

        Vol vol2 = new Vol();
        vol2.setNumero("abc2");

        Compagnie compagnie = new Compagnie();
        compagnie.setName("Air France");
        
        vol.setCompagnie(compagnie);      
        vol2.setCompagnie(compagnie);
        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }

        Compagnie volCompagnie = vol.getCompagnie();
        if (volCompagnie != null) {
            System.out.println(volCompagnie.getName());
        } else {
            System.out.println("Compagnie for vol is null");
        }
        
        Compagnie vol2Compagnie = vol2.getCompagnie();
        if (vol2Compagnie != null) {
            System.out.println(vol2Compagnie.getName());
        } else {
            System.out.println("Compagnie for vol2 is null");
        }

        try {
            vol2.setCompagnie(null);
            System.out.println("Compagnie for vol2 set to null");
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot set compagnie to null: " + e.getMessage());
        }
        
        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }
        
        System.out.println("\n----- Test de création d'aéroports -----");
        Aeroport paris = new Aeroport();
        paris.setNom("Charles de Gaulle");
        paris.setVille("Paris");
        
        Aeroport nice = new Aeroport();
        nice.setNom("Côte d'Azur");
        nice.setVille("Nice");
        
        System.out.println("Aéroport créé: " + paris.getNom() + " à " + paris.getVille());
        System.out.println("Aéroport créé: " + nice.getNom() + " à " + nice.getVille());
        
        vol.setDepart(paris);
        vol.setArrivee(nice);
        vol.setCapacite(100);        
        vol2.setDepart(nice);
        vol2.setArrivee(paris);
        vol2.setCapacite(150);

        System.out.println("\n----- Création des pièces d'identité -----");
        SimpleDateFormat dateBirth = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null, date2 = null, date3 = null;
        try {
            date1 = dateBirth.parse("15/05/1985");
            date2 = dateBirth.parse("23/11/1990");
            date3 = dateBirth.parse("07/09/1978");
        } catch (Exception e) {
            System.out.println("Erreur lors du parsing des dates de naissance");
            e.printStackTrace();
        }
        
        PieceIdentite piece1 = new PieceIdentite("1234567890", "Dupont", "Jean", 178, date1);
        PieceIdentite piece2 = new PieceIdentite("0987654321", "Martin", "Sophie", 165, date2);
        PieceIdentite piece3 = new PieceIdentite("5678901234", "Durand", "Pierre", 182, date3);
        
        System.out.println("Pièce d'identité créée: " + piece1);
        System.out.println("Pièce d'identité créée: " + piece2);
        System.out.println("Pièce d'identité créée: " + piece3);
        
        System.out.println("\n----- Test de création de passagers -----");
        Passager passager1 = new Passager(piece1);
        Passager passager2 = new Passager(piece2);
        Passager passager3 = new Passager(piece3);
        
        System.out.println("Passager créé: " + passager1.getNom() + " " + passager1.getPrenom());
        System.out.println("Passager créé: " + passager2.getNom() + " " + passager2.getPrenom());
        System.out.println("Passager créé: " + passager3.getNom() + " " + passager3.getPrenom());
        
        System.out.println("\n----- Test de vérification d'identité -----");
        PieceIdentite pieceCorrect = new PieceIdentite("1234567890", "Dupont", "Jean", 178, date1);
        PieceIdentite pieceIncorrect = new PieceIdentite("1111111111", "Martin", "Sophie", 165, date2);
        
        PieceIdentite.verifierIdentite(passager1, pieceCorrect);
        PieceIdentite.verifierIdentite(passager2, pieceIncorrect);
        
        System.out.println("\n----- Test de création de client -----");
        Client client = new Client("contact@exemple.com", "0123456789");
        client.ajouterPassager(passager1);
        client.ajouterPassager(passager2);
        System.out.println("Client créé avec " + client.getPassagers().size() + " passagers");
        
        System.out.println("\n----- Test de réservations -----");
        try {
            ZonedDateTime dateReservation = ZonedDateTime.now();
            
            Reservation reservation1 = Reservation.create(client, dateReservation, 150.0f, vol, passager1);
            System.out.println("Réservation créée pour " + passager1.getNom() + " sur le vol " + vol.getNumero());
            
            Reservation reservation2 = Reservation.create(client, dateReservation, 150.0f, vol, passager2);
            System.out.println("Réservation créée pour " + passager2.getNom() + " sur le vol " + vol.getNumero());
            
            reservation1.confirmer();
            reservation2.confirmer();
            
            System.out.println("\n----- Vérification des réservations -----");
            System.out.println("Le vol " + vol.getNumero() + " a " + vol.getReservation().size() + " réservations");
            
            System.out.println("\n----- Test d'annulation de réservation -----");
            reservation1.annuler();
            System.out.println("Réservation annulée pour " + passager1.getNom());
            System.out.println("Le vol " + vol.getNumero() + " a maintenant " + vol.getReservation().size() + " réservation(s)");
            
            System.out.println("\n----- Test de surréservation -----");
            for (int i = 0; i < 102; i++) {
                try {
                    Date dateNaissance = dateBirth.parse("01/01/2000");
                    PieceIdentite pieceTest = new PieceIdentite("ID" + i, "Test", "Passager" + i, 170, dateNaissance);
                    
                    Passager p = new Passager(pieceTest);
                    
                    Reservation r = Reservation.create(client, ZonedDateTime.now(), 150.0f, vol, p);
                    r.confirmer();                    
                    System.out.println("Réservation " + i + " créée");
                } catch (IllegalArgumentException e) {
                    System.out.println("Erreur de réservation: " + e.getMessage());
                    break;
                } catch (Exception e) {
                    System.out.println("Autre erreur: " + e.getMessage());
                    e.printStackTrace();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur lors des tests de réservation: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
}
