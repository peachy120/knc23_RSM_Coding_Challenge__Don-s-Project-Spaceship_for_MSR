public class Starships {
    Fleets fleets;

    private int maxAttackStrength;
    private int maxDefStrength;
    private int maxCrewNo;
    private int maxHealth;
    private int currentHealth;
    private int currentCrewNo;
    private int currentAttackStrength;
    private int currentDefStrength;

    private String sector;

    private boolean isStarbaseDockedIn = false;

    private boolean ableToAttack = true;
    private boolean ableToMove = true;

    private int noOfSubsequentActionsSkip = 0;
    //------------------------------------------------------------------------------------------------------------------

    public Starships(int maxAttackStrength, int maxDefStrength, int maxCrewNo, int maxHealth) {
        this.maxAttackStrength = maxAttackStrength;
        this.maxDefStrength = maxDefStrength;
        this.maxCrewNo = maxCrewNo;
        this.maxHealth = maxHealth;
        //this.currentHealth = currentHealth;
        //this.currentCrewNo = currentCrewNo;
        //this.currentAttackStrength = maxAttackStrength * (currentHealth / maxHealth);
        this.currentDefStrength = maxDefStrength * ( (currentHealth + currentCrewNo) / (maxHealth + maxCrewNo) );
        //this.sector = sector;
        //this.isStarbaseDockedIn = starbaseDockedIn;
    }

    //------------------------------------------------------------------------------------------------------------------
    // getter
    public int getMaxAttackStrength() {
        return maxAttackStrength;
    }

    public int getMaxDefStrength() {
        return maxDefStrength;
    }

    public int getMaxCrewNo() {
        return maxCrewNo;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getCurrentCrewNo() {
        return currentCrewNo;
    }

    public int getCurrentAttackStrength() {
        return currentAttackStrength;
    }

    public int getCurrentDefStrength() {
        return currentDefStrength;
    }

    public String getSector() {
        return sector;
    }

    public boolean isIsStarbaseDockedIn() {
        return isStarbaseDockedIn;
    }

    //------------------------------------------------------------------------------------------------------------------
    // setter
    public void setMaxAttackStrength(int maxAttackStrength) {
        this.maxAttackStrength = maxAttackStrength;
    }

    public void setMaxDefStrength(int maxDefStrength) {
        this.maxDefStrength = maxDefStrength;
    }

    public void setMaxCrewNo(int maxCrewNo) {
        this.maxCrewNo = maxCrewNo;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setCurrentCrewNo(int currentCrewNo) {
        this.currentCrewNo = currentCrewNo;
    }

    public void setCurrentAttackStrength(int currentAttackStrength) {
        this.currentAttackStrength = currentAttackStrength;
    }

    public void setCurrentDefStrength(int currentDefStrength) {
        this.currentDefStrength = currentDefStrength;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setIsStarbaseDockedIn(boolean isStarbaseDockedIn) {
        this.isStarbaseDockedIn = isStarbaseDockedIn;
    }
    //------------------------------------------------------------------------------------------------------------------
    // Actions
    public void moveToSector() {

    }

    /// ----------------------------------------------------------------------------------------------------------------

    public void dockWithStarbase() {
        if ( isStarbaseDockedIn = false) {
            if ( sector.equals(fleets.getSector())) {
                setIsStarbaseDockedIn(true);
                System.out.println("Docked in with starbase");
                ableToAttack = false;
                System.out.println("Starship cannot attack now");
                ableToMove = false;
                System.out.println("Starship cannot move now");
            }
        }
    }

    /// ----------------------------------------------------------------------------------------------------------------

    public void undockFromStarbase() {
        if ( isStarbaseDockedIn = true) {
            setIsStarbaseDockedIn(false);
            System.out.println("Undocked from starbase");
            ableToAttack = true;
            System.out.println("Starship can attack now");
            ableToMove = true;
            System.out.println("Starship can move now");
        }
    }

    /// ----------------------------------------------------------------------------------------------------------------

    public void repair() {
        if (isStarbaseDockedIn = true) {
            setCurrentHealth(getMaxHealth());
            System.out.println("Spaceship's current health is set to maximum");
            setCurrentCrewNo(getMaxCrewNo());
            System.out.println("SpaceShip's current crew number is set to maximum");
            if (currentHealth < (0.25 * maxHealth)) {
                noOfSubsequentActionsSkip = 4;
                System.out.println("This spaceship need to skip the next 4 subsequent actions");
            } else if (currentHealth >= (0.25 * maxHealth) && currentHealth <= (0.49 * maxHealth)) {
                noOfSubsequentActionsSkip = 3;
                System.out.println("This spaceship need to skip the next 3 subsequent actions");
            } else if (currentHealth >= (0.5 * maxHealth) && currentHealth <= (0.74 * maxHealth)) {
                noOfSubsequentActionsSkip = 2;
                System.out.println("This spaceship need to skip the next 2 subsequent actions");
            } else if (currentHealth >= (0.75 * maxHealth)) {
                noOfSubsequentActionsSkip = 1;
                System.out.println("This spaceship need to skip the next 1 subsequent actions");
            }
        } else {
            System.out.println("Your spaceship is not docked into the starbase");
        }
    }

    /// ----------------------------------------------------------------------------------------------------------------

    public void attackTarget() {

    }
}
