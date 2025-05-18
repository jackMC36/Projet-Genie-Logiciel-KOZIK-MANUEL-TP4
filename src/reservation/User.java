package reservation;

// Classe représentant un utilisateur avec un login et un mot de passe.
public class User {
    // Attributs privés pour garantir l'encapsulation.
    private final String login; // Le login de l'utilisateur.
    private final String motDePasse; // Le mot de passe de l'utilisateur.

    /**
     * Constructeur de la classe User.
     * Initialise un utilisateur avec un login et un mot de passe.
     *
     * @param l Le login de l'utilisateur.
     * @param mdp Le mot de passe de l'utilisateur.
     */
    public User(String l, String mdp) {
        this.login = l;
        this.motDePasse = mdp;
    }

    /**
     * Retourne le login de l'utilisateur.
     *
     * @return Le login de l'utilisateur.
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Retourne l'instance actuelle de l'utilisateur.
     * Cette méthode semble redondante, car elle retourne simplement l'objet lui-même.
     *
     * @return L'instance actuelle de l'utilisateur.
     */
    public User getUser() {
        return this;
    }
}