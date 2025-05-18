import aeroport.Compagnie;
import aeroport.Vol;

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
        compagnie.addVol(vol);
        compagnie.addVol(vol2);

        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }

        System.out.println(vol.getCompagnie().getName());
        System.out.println(vol2.getCompagnie().getName());

        vol2.setCompagnie(null);
        System.out.println(vol2.getCompagnie());

        for(Vol v : compagnie.getVols()){
            System.out.println(v.getNumero());
        }
    }
}
