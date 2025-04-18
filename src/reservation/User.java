package reservation;

public class User {
    private static String login;
    private static String motDePasse;


    public User(String l, String mdp){
        this.login = l;
        this.motDePasse = mdp;
    }

    private String getLogin(){
        return this.login;
    }

    
}
