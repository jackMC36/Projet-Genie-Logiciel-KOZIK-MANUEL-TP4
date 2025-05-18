package reservation;

/**
 * Classe représentant un utilisateur dans le système
 */
public class User {
    private final String email;
    private String password;
    private final String telephone;
    
    /**
     * Constructeur de la classe User
     * 
     * @param email L'adresse email de l'utilisateur
     * @param password Le mot de passe de l'utilisateur
     * @param telephone Le numéro de téléphone de l'utilisateur
     */
    public User(String email, String password, String telephone) {
        this.email = email;
        this.password = password;
        this.telephone = telephone;
    }
    
    /**
     * Retourne l'adresse email de l'utilisateur
     * 
     * @return L'adresse email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Permet de modifier le mot de passe de l'utilisateur
     * 
     * @param oldPassword L'ancien mot de passe pour vérification
     * @param newPassword Le nouveau mot de passe
     * @return true si le mot de passe a été modifié, false sinon
     */
    public boolean changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }
    
    /**
     * Retourne le numéro de téléphone de l'utilisateur
     * 
     * @return Le numéro de téléphone
     */
    public String getTelephone() {
        return telephone;
    }
}