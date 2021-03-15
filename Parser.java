import java.util.StringTokenizer;

public class Parser 
{
    private CommandWords aValidCommands;  // (voir la classe CommandWords)

    /**
     * Constructeur par defaut qui cree les 2 objets prevus pour les attributs
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();      
    } // Parser()

    /**
     * @return The next command from the user.
     */
    public Command getCommand(final String pInputLine) 
    {
        String vWord1;
        String vWord2;

        System.out.print( "> " );  // affiche le prompt (invite de commande)
        
        StringTokenizer vTokenizer = new StringTokenizer( pInputLine );
        if ( vTokenizer.hasMoreTokens() ) 
            vWord1 = vTokenizer.nextToken();// recupere le premier mot
        else
            vWord1 = null;
        
        if ( vTokenizer.hasMoreTokens() ) 
            vWord2 = vTokenizer.nextToken();  // recupere le deuxieme mot
        else 
            vWord2 = null;
        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).

        if ( this.aValidCommands.isCommand( vWord1 ) )
            return new Command( vWord1, vWord2 );
        else
            return new Command( null, vWord2 );
    } // getCommand()
    
    /**
    * Affiche la liste des commandes (valides) répertorier dans aValidCommands de la class CommandWords;
    * Appelle de la méthode showAll() pour ce faire;
    */
    public void showCommands()
    {
        aValidCommands.getCommandList();
    }
} // Parser
