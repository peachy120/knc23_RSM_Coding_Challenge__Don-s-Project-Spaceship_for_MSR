import java.util.ArrayList;

public class Starbases {
    Starships starships;

    // Attributes
    private Fleets fleets;
    public String starbaseName;
    private Sector sector;

    private int maxDefStrength = 20;
    private int maxHealth = 500;

    private int currentDefStrength;
    public int currentHealth;

    private int currentAttackStrength;

    private ArrayList<Starships> dockedShips;

    //------------------------------------------------------------------------------------------------------------------
    // This is the constructor, creating the current object. setting up the starting state of the starbase
    public Starbases(String starbaseName, Sector sector) {
        this.fleets = null;
        this.starbaseName = starbaseName;
        this.sector = sector;

        this.currentDefStrength = maxDefStrength;
        this.currentHealth = maxHealth;

        this.currentAttackStrength = currentAttackStrength;

        this.dockedShips = new ArrayList<>();
    }

    @Override
    public String toString() {
        return starbaseName;
    }
    //------------------------------------------------------------------------------------------------------------------
    // this is getter
    public Fleets getFleets() {
        return fleets;
    }

    public String getStarbaseName() {
        return starbaseName;
    }

    public Sector getSector() {
        return sector;
    }

    /// ----------------------------------------------------------------------------------------------------------------

    public int getMaxDefStrength() {
        return maxDefStrength;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    /// ----------------------------------------------------------------------------------------------------------------

    public int getCurrentDefStrength() {
        currentDefStrength = ( maxDefStrength * (currentHealth / maxHealth)) + (fleets.dockedShipCurrentDefenceStrength() * (fleets.noOfDockedStarship() / maxDefStrength));
        return currentDefStrength;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getCurrentAttackStrength() {return currentAttackStrength;}

    /// ----------------------------------------------------------------------------------------------------------------

    public ArrayList<Starships> getDockedShips() {
        return dockedShips;
    }

    //------------------------------------------------------------------------------------------------------------------
    // this is setter

    public void setFleets(Fleets fleets) {
        this.fleets = fleets;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    /// ----------------------------------------------------------------------------------------------------------------

    public void setCurrentDefStrength(int currentDefStrength) {
        this.currentDefStrength = currentDefStrength;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setCurrentAttackStrength(int currentAttackStrength) { this.currentAttackStrength = currentAttackStrength; }

    /// ----------------------------------------------------------------------------------------------------------------

    public void setDockedShips(ArrayList<Starships> dockedShips) {
        this.dockedShips = dockedShips;
    }

    //------------------------------------------------------------------------------------------------------------------
    // actions

    public void attackTarget(Starships target) {
        currentAttackStrength = 0;

        for (Starships starship : getDockedShips()) {
            if (starship.getBeingRepaired() == true) {
                currentAttackStrength = 0;
                currentAttackStrength = 0 + starship.getCurrentDefStrength();
            }
            currentAttackStrength = currentAttackStrength + starship.getCurrentAttackStrength();
        }

    }

}
