import java.util.ArrayList;

public class Fleets {
    private int playerID;
    private Starbases starbases;
    private ArrayList<Starships> starships;

    //------------------------------------------------------------------------------------------------------------------

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
    public int dockedShipCurrentDefenceStrength() {
        int currentDefenceStrength = 0;
        for (Starships starship : starbases.getDockedShips()) {
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

}
