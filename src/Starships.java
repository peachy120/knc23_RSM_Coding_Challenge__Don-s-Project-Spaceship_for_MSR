public class Starships {
    Starbases starbases;

    private Fleets fleets;
    private String starshipName;
    private Sector sector;

    private int maxAttackStrength = 30;
    private int maxDefStrength = 10;
    private int maxCrewNo = 10;
    private int maxHealth = 100;

    private int currentHealth;
    private int currentCrewNo;
    private int currentAttackStrength;
    private int currentDefStrength;

    private boolean isStarbaseDockedIn = false;

    private boolean ableToAttack = true;
    private boolean ableToMove = true;

    private boolean isDestroy = false;

    private int noOfSubsequentActionsSkip = 0;
    //------------------------------------------------------------------------------------------------------------------

    public Starships(Fleets fleets, String starshipName, Sector sector) {
        this.fleets = fleets;
        this.starshipName = starshipName;
        this.sector = sector;

        this.currentHealth = maxHealth;
        this.currentCrewNo = maxCrewNo;
        this.currentAttackStrength = maxAttackStrength;
        this.currentDefStrength = maxDefStrength;

        this.isStarbaseDockedIn = false;
        this.isDestroy = false;
    }

    //------------------------------------------------------------------------------------------------------------------
    // getter
    public Fleets getFleets() {
        return fleets;
    }

    public Sector getSector() {
        return sector;
    }

    /// ----------------------------------------------------------------------------------------------------------------

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

    /// ----------------------------------------------------------------------------------------------------------------

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getCurrentCrewNo() {
        return currentCrewNo;
    }

    public int getCurrentAttackStrength() {
        currentAttackStrength = maxAttackStrength * (currentHealth / maxHealth);
        return currentAttackStrength;
    }

    public int getCurrentDefStrength() {
        currentDefStrength = maxDefStrength * ( (currentHealth + currentCrewNo) / (maxHealth + maxCrewNo) );
        return currentDefStrength;
    }

    /// ----------------------------------------------------------------------------------------------------------------

    public boolean isIsStarbaseDockedIn() {
        return isStarbaseDockedIn;
    }

    public boolean isDestroy() {
        return isDestroy;
    }

    //------------------------------------------------------------------------------------------------------------------
    // setter
    public void setSector(Sector sector) {
        this.sector = sector;
    }

    /// ----------------------------------------------------------------------------------------------------------------

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

    /// ----------------------------------------------------------------------------------------------------------------

    public void setIsStarbaseDockedIn(boolean isStarbaseDockedIn) {
        this.isStarbaseDockedIn = isStarbaseDockedIn;
    }

    public void setIsDestroy(boolean isDestroy) {
        this.isDestroy = isDestroy;
    }


    //------------------------------------------------------------------------------------------------------------------
    // Actions
    public void moveToSector(Sector updatedSector) {
        sector = updatedSector;
        System.out.println(starshipName + " is now moved to " + sector.getSector());
    }

    /// ----------------------------------------------------------------------------------------------------------------

    public void dockWithStarbase() {
        if ( isStarbaseDockedIn = false) {
            if ( sector.equals(starbases.getSector())) {
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

    public void attackStarshipTarget(Starships targetStarship) {
        // Calculating which amount of damage is higher
        int targetDamageAmountByCalculation = getCurrentAttackStrength() - targetStarship.getCurrentDefStrength();
        int higherStarshipDamage = targetDamageAmountByCalculation;
        if (targetDamageAmountByCalculation > 5) {
            higherStarshipDamage = targetDamageAmountByCalculation;
            System.out.println("Target Starship Damage Amount By Calculation is: " + targetDamageAmountByCalculation + ", which is higher");
        } else {
            higherStarshipDamage = 5;
            System.out.println("5 is higher than the Target Starship Damage Amount By Calculation");
        }

        // Calculating the number of crew members from target starship were incapacitated in the attack
        int targetCrewNoLost = (getCurrentAttackStrength() / targetStarship.getMaxHealth()) * targetStarship.currentCrewNo;

        // Checking is the attack starship and target starship from the same fleet
        if (targetStarship.fleets != (getFleets())) {

            //Checking is the attack starship and target starship within the same sector
            if (targetStarship.getSector().equals(getSector())) {
                System.out.println("Attack starship is in the same sector with target starship");

                if (targetStarship.isStarbaseDockedIn = false) {
                    // Calculating and setting the current health of target starship after being attack
                    targetStarship.setCurrentHealth(targetStarship.currentHealth - higherStarshipDamage);
                    System.out.println(targetStarship.starshipName + " current health after being attack is: " + targetStarship.currentHealth);

                    if (targetStarship.currentHealth != 0) {
                        System.out.println("Target Starship current health is larger than 0 after being attack");

                        // Checking how many crew member are currently on target starship
                        if (targetStarship.currentCrewNo < 1) {
                            System.out.println("Target starship has more than 1 crew member");
                            if ((targetStarship.currentCrewNo - targetCrewNoLost) < targetStarship.currentCrewNo) {
                                System.out.println("After losing " + targetCrewNoLost + " there will be 1 or more crew member left");
                                targetStarship.setCurrentCrewNo(targetStarship.currentCrewNo - targetCrewNoLost);
                                System.out.println("Target starship amount current crew member left after being attack: " + targetStarship.currentCrewNo);
                            } else {
                                System.out.println("After losing " + targetCrewNoLost + " there will be no crew member left");
                                targetStarship.setCurrentCrewNo(1);
                                System.out.println("Target starship amount current crew member left after being attack: " + targetStarship.currentCrewNo);
                            }
                        } else {
                            System.out.println("Target starship only has 1 crew member, so the amount of crew number dose not change");
                        }
                    } else {
                        System.out.println("Target Starship current health is 0");
                        targetStarship.fleets.removeStarship(targetStarship);
                    }
                } else {
                    System.out.println("Target starship is currently docked in, cannot attack");
                }
            } else {
                System.out.println("Attack starship is not in the same sector with target starship");
            }
        }else {
            System.out.println("Cannot attack starships within the same fleet");
        }
    }


    public void attackStarbaseTarget(Starbases targetStarbase) {
        // Calculating which damage is higher
        int targetStarbaseDamageByCalculation = getCurrentAttackStrength() - targetStarbase.getCurrentDefStrength();
        int higherStarbaseDemage = targetStarbaseDamageByCalculation;
        if (targetStarbaseDamageByCalculation > 5) {
            higherStarbaseDemage = targetStarbaseDamageByCalculation;
            System.out.println("Target Starbase Damage Amount By Calculation is: " + targetStarbaseDamageByCalculation + ", which is higher");
        } else {
            higherStarbaseDemage = 5;
            System.out.println("5 is higher than the Target Starbase Damage Amount By Calculation");
        }

        // Checking is the attack starship and target starbase from the same fleet
        if (targetStarbase.getFleets() != getFleets()) {

            // Checking is attack starship and target starbase within the same sector
            if (targetStarbase.getSector().equals(getSector())) {
                System.out.println("Attack starship is in the same sector with target starbase");

                targetStarbase.setCurrentHealth(targetStarbase.currentHealth - higherStarbaseDemage);
                System.out.println(targetStarbase.starbaseName + " current health after being attack is: " + targetStarbase.currentHealth);

            } else {
                System.out.println("Attack starship is not in the same sector with target starbase");
            }
        } else {
            System.out.println("Cannot attack starbase within the same fleet");
        }
    }
}
