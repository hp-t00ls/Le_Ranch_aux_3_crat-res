import java.util.HashMap;
import java.util.Set;

public class Room
{
   private String aDescription;
   private HashMap<String, Room> aExits;//stores exits of this room
   private String aImageName;
   
    /**
     * Créer une Room décrite comme "description".
     * Au départ, il n'a pas de sorties. 
     */ 
   public Room(final String pDescription, final String pImage) {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String,Room>();
        this.aImageName = pImage;
   }
   
     /**
     * @return la description de la Room.
     */
   public String getShortDescription() {
        return this.aDescription;
   }
   
   /**      
     * Affiche une description détaillée de cette pièce.
     * @return une description de la pièce, les objets et personnages qui s'y trouvent, avec les sorties.
     */
    
   public String getLongDescription()
   {   
       return " You are in " + this.aDescription + ".\n" + getExitString();
   }
   
   /**
     * @return la Room qui est atteinte si nous partons de cette Room dans la direction "direction".
     * S'il n'y a pas de Room dans cette direction, la méthode renvoie null.
     */
   public Room getExit(String pDirection)
   {
    return this.aExits.get(pDirection);   
   }
   
   /**
     * Renvois une description des sorties de la pièce,
     * par exemple : "Exits : North West"
     * @return une description des sorties possibles.
     */
  
   public String getExitString()
    {
    String vReturnString = "Exits: ";
    Set<String> vKeys = aExits.keySet();
    for(String vExit : vKeys)
    {
        vReturnString += " "+vExit;
    }
    return vReturnString;
   }

   /**
    * Définit les sorties de cette Room; 
    * Chaque direction mène à une autre pièce ou est nulle; 
    */
   public void setExit(final String pDirection,
   final Room pNeighbor) {
        this.aExits.put(pDirection, pNeighbor);  
   }
   
   /**
     * Return a string describing the room's image name
     */
   public String getImageName()
   {
        return this.aImageName;
   }
   
} // Room 