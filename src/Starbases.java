public class Starbases {
    Starships starships;

    // Attributes
    private int maxDefStrength;
    private int dockedShips;
    private int maxHealth;
    private int currentDefStrength;
    private int currentHealth;

    //------------------------------------------------------------------------------------------------------------------

    public Starbases (int maxDefStrength, int maxHealth) {
        this.maxDefStrength = maxDefStrength;
        //this.dockedShips = dockedShips;
        this.maxHealth = maxHealth;
        this.currentDefStrength = ( maxDefStrength * (currentHealth / maxHealth) ) + ( (dockedShips * starships.getCurrentDefStrength()) * (dockedShips / maxDefStrength) );
        //this.currentHealth = currentHealth;
    }

    //------------------------------------------------------------------------------------------------------------------
    // this is getter
    public int getMaxDefStrength(){
        return maxDefStrength;
    }

    public int getDockedShips() {
        return dockedShips;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentDefStrength() {
        return currentDefStrength;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    //------------------------------------------------------------------------------------------------------------------
    // this is setter
    public void setMaxDefStrength(int maxDefStrength) {
        this.maxDefStrength = maxDefStrength;
    }

    public void setDockedShips(int dockedShips) {
        this.dockedShips = dockedShips;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setCurrentDefStrength(int currentDefStrength) {
        this.currentDefStrength = currentDefStrength;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
}
