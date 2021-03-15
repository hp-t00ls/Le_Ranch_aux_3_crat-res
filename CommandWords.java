 

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    private final String[] aValidCommands;
    /**
     * Constructor - initialise the command words.
     * Les options (go, help, quit, look, eat) sont stockés dans le tableau aValidCommands;
     */
    public CommandWords()
    {
        this.aValidCommands = new String[5];
        this.aValidCommands[0] = "go";
        this.aValidCommands[1] = "help";
        this.aValidCommands[2] = "quit";
        this.aValidCommands[3] = "look";
        this.aValidCommands[4] = "lasso";
    } // CommandWords() 
    
    /**
     * @param pString est une commande rentrée par l'utilisateur;
     * Cette commande est ainsi comparé avec les éléments du tableau aValidCommands[];
     * @return true si le string saisie est égal à une commande contenue dans le tableau;
     * @return false si le string est égal à aucune des commandes; 
     */
    public boolean isCommand( final String pString )
    {
        for ( int i=0; i<this.aValidCommands.length; i++ ) {
            if ( this.aValidCommands[i].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands
        return false;
    } // isCommand()
    
    public String getCommandList()
    {
        /**
         * Méthode getCommandList() prépare une liste String contenant toute les commandes avec l'utilisation 
         * de la classe StringBuilder et la méthode append() permettant de réunir un grand nombre de String à la suite;
         */
        StringBuilder vCommand = new StringBuilder(); //StringBuilder est une chaîne de caractères nécessitant
        //d'agréger une grande quantité d'informations;
        for(int i = 0; i < aValidCommands.length; i++) {
                vCommand.append( aValidCommands[i] + " " );//.append permet d'insérer un nouveau String à vCommand;
        }
        return vCommand.toString();
    }
    
} // CommandWords