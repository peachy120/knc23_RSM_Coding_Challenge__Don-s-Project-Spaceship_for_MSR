import java.util.ArrayList;

public class Fleets {
    private int playerID;
    private Starbases starbases;
    private ArrayList<Starships> starships;

    //------------------------------------------------------------------------------------------------------------------
    // This is the constructor, creating the current object. setting up the starting state of the fleet
    public Fleets(int playerID, Starbases starbases) {
        this.playerID = playerID;
        this.starbases = starbases;
        this.starships = new ArrayList<>();
    }

    //------------------------------------------------------------------------------------------------------------------

    public void addStarship(Starships starship) {
        starships.add(starship);
        System.out.println(playerID + "has a new Starship");
    }

    public void removeStarship(Starships starship) {
        getStarships().remove(starship);
        System.out.println(playerID + "'s Starship: " + starship + "has been destroyed and being removed");
    }

    //------------------------------------------------------------------------------------------------------------------

    public int getPlayerID() {
        return playerID;
    }

    public Starbases getStarbases() {
        return starbases;
    }

    public ArrayList<Starships> getStarships() {
        return starships;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setStarbases(Starbases starbases) {
        this.starbases = starbases;
    }

    public void setStarships(ArrayList<Starships> starships) {
        this.starships = starships;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Actions
    public void mobiliseToSector() {

    }

    /// ----------------------------------------------------------------------------------------------------------------

    public void attackTarget() {

    }

    //------------------------------------------------------------------------------------------------------------------
    // Calculating the total of current defence strength of starships that are docked in
    public int dockedShipCurrentDefenceStrength2() {
        int currentDefenceStrength = 0;
        for (Starships starship : starbases.getDockedShips()) {
            currentDefenceStrength = currentDefenceStrength + starship.getCurrentDefStrength();
        }
        return currentDefenceStrength;
    }

    public int dockedShipCurrentDefenceStrength() {
        int currentDefenceStrength = 0;
        for (Starships starship : starbases.getDockedShips()) {
            if (starship.getBeingRepaired() == true) {
                currentDefenceStrength = 0;
                currentDefenceStrength = 0 + starship.getCurrentDefStrength();
            }
            currentDefenceStrength = currentDefenceStrength + starship.getCurrentDefStrength();
        }
        return currentDefenceStrength;
    }

    // Calculating the total of current defence strength of starships that are docked in
    public int noOfDockedStarship() {
        int count = 0;
        for (Starships starship : starships) {
            count = count + 1;
        }
        return count;
    }

    public void towStarbase(Sector sector) {

        for (Starships starship : starships) {
            if (starship.getFleets() != starbases.getFleets()) {
                starship.moveToSector(starbases.getSector());
            }
        }

    }

}
