package reservation;

public class User {
    private final String login;
    private final String motDePasse;


    public User(String l, String mdp){
        this.login = l;
        this.motDePasse = mdp;
    }

    public String getLogin(){
        return this.login;
    }

    public User getUser(){
        return this;
    }
}
