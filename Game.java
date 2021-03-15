public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    
    /**
     * Constructeur par defaut qui cree les 13 Rooms du jeu et les localisent entre elles;
     * Appelle de la méthode SetExit pour fixer la position de sortie de chaque Room;
     */
    private void createRooms()
    {
        //creating the differents rooms
        Room vPastures = new Room("in the galactic pastures");
        Room vCrater_3 = new Room("in the third crater, a natural pen which usually contains the missing buggalos");
        Room vCrater_2 = new Room("in the second crater, a natural pen which usually contains the missing buggalos");
        Room vCrater_1 = new Room("in the first crater, a natural pen which usually contains the missing buggalos");
        Room vWreck = new Room("in a mysterious wreck"); 
        Room vSAS_1 = new Room("in the aces one");
        Room vSAS_2 = new Room("in the aces two");
        Room vBarn = new Room("in the barn");
        Room vSlury = new Room("in the slury pit, it smells bad");
        Room vVolcano = new Room("on top of the Olympus Mons");
        Room vDesert = new Room("out of the Ranch, in the martian desert");
        Room vMilking = new Room("in the milking parlor");
        Room vRanch = new Room("in the Ranch");
        
        
        //set exits
        vPastures.setExit("East", vSlury);
        
        vMilking.setExit("South", vBarn);
        
        vSlury.setExit("South", vCrater_3);
        vSlury.setExit("East", vBarn);
        
        vBarn.setExit("North", vMilking);
        vBarn.setExit("South", vSAS_1);
        vBarn.setExit("West", vSlury);
        vBarn.setExit("East", vDesert);
        
        vSAS_2.setExit("West", vCrater_3);
        vSAS_2.setExit("North", vRanch);
        vSAS_2.setExit("South", vVolcano);
        
        vVolcano.setExit("North", vSAS_2);
        vVolcano.setExit("West", vWreck);
        
        vWreck.setExit("East", vVolcano);
        
        vSAS_1.setExit("North", vBarn);
        vSAS_1.setExit("West", vRanch);
        vSAS_1.setExit("East", vCrater_1); 
        vSAS_1.setExit("South", vCrater_2);
        
        vCrater_3.setExit("North", vSlury);
        vCrater_3.setExit("East", vSAS_2);
        vCrater_2.setExit("North", vSAS_1);
        vCrater_2.setExit("East", vDesert);
        vCrater_1.setExit("West",vSAS_1);
        vCrater_1.setExit("East",vDesert);
        
        vRanch.setExit("South", vSAS_2);
        vRanch.setExit("East", vSAS_1);
        
        //set current room
        this.aCurrentRoom = vRanch;
    }
    
    /**
     * Constructeur par defaut qui appelle le constructeur CreateRooms() pour créer les Rooms;
     * this.aParser = new Parser() permet la saisie d'une nouvelle commande par l'utilisateur;
     * Appelle de la procédure play(), permet de lancer le jeu directement en cliquant sur new Game();
     */
    public Game()
    {
        this.createRooms();
        this.aParser = new Parser();
        this.play();
    }
    
    /**
     * Procédure printLocationInfo() permet d'alléger la méthode goRoom;
     * Appelle de la méthode/accesseur getDescription() pour faire afficher la Room courante;
     * Appelle de la méthode/accesseur getExitString() pour faire afficher les sorties possibles de la Room courante;
     */
    private void printLocationInfo()
    {
        System.out.println("You are " + this.aCurrentRoom.getDescription());
        System.out.print(this.aCurrentRoom.getExitString());
    }

    /**
     * @param pCommand est un input rentrée par l'utilisateur, elle est transcris comme une commande ;
     * par la classe Parser; 
     * pCommand est définit sur 2 mots;
     * La pièce courrante change en fonction de la commande rentrée; 
     */
    private void goRoom(final Command pCommand)
    { 
       if (!pCommand.hasSecondWord()) {
           System.out.println("Go where ?");
           return;
       } else {
           Room vNextRoom = null;
           String vDirection = pCommand.getSecondWord();
           vNextRoom = aCurrentRoom.getExit(vDirection);
           if (vNextRoom == null) {
               System.out.println("There is no door or Unknown direction");
           } else {
               this.aCurrentRoom = vNextRoom;
               this.printLocationInfo();
               System.out.println();
           }
       }
    }
    
    /**
     * Procédure printWelcome() affiche le texte de Bienvenue et la Room currente et ses sorties possibles;
     */
    private void printWelcome() {
        System.out.println("Welcome to the three craters ranch!");
        System.out.println("The three craters ranch is a new, warm and incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println("You are " + this.aCurrentRoom.getDescription());
        System.out.print(this.aCurrentRoom.getExitString());
    }
    
    /**
     * Procédure printHelp() affiche toutes les commandes possibles à saisir jeu si besoin;
     */
    private void printHelp() 
    {
       System.out.println("You are lost. You are alone.");
       System.out.println("You wander around at the university.");
       System.out.println("Your command words are:");
       aParser.showCommands(); 
    }
    
    /**
     * @param pCommand est un input rentrée par l'utilisateur (Parser) définit sur 2 mots;
     * Si un second mot est rentré dans la commande, la méthode affiche "quit What??";
     */
    private boolean quit(final Command pCommand)
    {
        if (pCommand.hasSecondWord()){
            System.out.println("quit What??");
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * @param pCommand est un input rentrée par l'utilisateur (Parser) définit sur 2 mots;
     * Si la commande saisie ne correspond à aucune commande définie dans le jeu, la méthode affiche "I don't know...";
     * Si le premier mot de la commande saisie est égale à "help", alors on appelle la procédure printHelp();
     * Si le premier mot de la commande saisie est égale à "go", alors on appelle la méthode goRoom(); 
     * (le second mot de la commande définira alors la direction);
     * Si le premier mot de la commande saisie est égale à "look", alors on appelle la procédure look();
     * Si le premier mot de la commande saisie est égale à "eat", alors on appelle la procédure eat();
     * Si le premier mot de la commande saisie est égale à "quit", alors le second mot de la commande devient null;
     * @return un boolean valant toujours false;
     */
    private boolean processCommand(final Command pCommand)
    {
        if (pCommand.isUnknown()) System.out.println("I don't know what you mean..."); 
            /*} else {
            String vCommandWord = pCommand.getCommandWord();
            String vSecondWord = pCommand.getSecondWord();
            */ 
        else if (pCommand.getCommandWord().equals("help")) printHelp();
        
        else if (pCommand.getCommandWord().equals("go")) goRoom(pCommand);
        
        else if (pCommand.getCommandWord().equals("look"))  look();
        
        else if (pCommand.getCommandWord().equals("lasso"))   lasso();
        
        else if (pCommand.getCommandWord().equals("quit")){ 
            Command vCommand = new Command(pCommand.getSecondWord(), null);
            return quit(vCommand);
        }
        return false; 
    }
    
    /**
     * Tant que la commande quit n'a pas été saisie, le jeu continu;
     * Sinon le jeu, s'arrête et affiche un messege de fin;
     */
    public void play() {
        printWelcome();
        boolean vFinished = false;
        while (!vFinished) {
            Command vCommand = this.aParser.getCommand();
            vFinished = processCommand(vCommand);
            
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    /**      
      * Permet de faire l'etat des lieux.
      * @return la description de la pièce où l'on se trouve.
      */
    private void look()
    { 
        System.out.println(this.aCurrentRoom.getLongDescription());
    } 
    
    /**
      * Permet de manger quelque chose.
      */
    private void lasso()
    {
        System.out.println("You caught a buggalo, well done !");
    }
} // Game
