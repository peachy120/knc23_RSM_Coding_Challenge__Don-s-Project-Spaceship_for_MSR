import java.util.ArrayList;

public class Fleets {
    private int playerID;
    private String starbases;
    private ArrayList<Starships> starships;

    //------------------------------------------------------------------------------------------------------------------

    public Fleets(int playerID, String starbases) {
        this.playerID = playerID;
        this.starbases = starbases;
        this.starships = new ArrayList<>();
    }

    //------------------------------------------------------------------------------------------------------------------

    public void addStarship(Starships starship){
        starships.add(starship);
        System.out.println(playerID + "has a new Starship");
    }

    public void removeStarship(Starships starship) {
        starships.remove(starship);
        System.out.println(playerID + "'s Starship: " + starship + "has been destroyed and being removed");
    }

    //------------------------------------------------------------------------------------------------------------------

    public int getPlayerID() {
        return playerID;
    }

    public String getStarbases() {
        return starbases;
    }

    public ArrayList<Starships> getStarships() {
        return starships;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setStarbases(String starbases) {
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
        for (Starships starship : starships) {
            if (starship.isIsStarbaseDockedIn()) {
                currentDefenceStrength = currentDefenceStrength + starship.getCurrentDefStrength();
            }
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

    public void moveAllToSector(Sector updateSector) {
        for (Starships starship : starships) {
            starship.moveToSector(updateSector);
        }
    }
}
