public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
    * Constructeur naturel 
    * @param pCommandWord premier mot de la commande;
    * @param pSecondWord second mot de la commande;
    * Initialise les attribut avec les commandes de l'utilisateur;
    */
    public Command(final String pCommandWord,final String pSecondWord) {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }
    
    /**
    * Accesseur de l'attribut aCommandWord;
    */
    public String getCommandWord() {
        return this.aCommandWord;
    }
    
    /**
    * Accesseur de l'attribut aSecondWord;
    */
    public String getSecondWord() {
        return this.aSecondWord;
    }
    
    /**
    * Méthode qui vérifie que la commande contient un second mot;
    * @return un boolean qui vaut true si le second mot existe, false sinon;
    */
    public boolean hasSecondWord() {
        return this.aSecondWord != null;
    }
    
    /**
    * Méthode qui vérifie que la commande saisie existe (non égal à null);
    * @return un boolean qui vaut true si le premier mot indicant l'action existe, false sinon;
    */
    public boolean isUnknown() {
        return this.aCommandWord == null;
    }
    
    
} // Command
