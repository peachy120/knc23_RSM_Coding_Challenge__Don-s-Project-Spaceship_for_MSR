public class Fleets {
    private int playerID;
    private int starships;
    private int starbases;
    private int sector;

    //------------------------------------------------------------------------------------------------------------------

    public Fleets(int playerID, int starships, int starbases, int sector) {
        this.playerID = playerID;
        this.starships = starships;
        this.starbases = starbases;
        this.sector = sector;
    }

    //------------------------------------------------------------------------------------------------------------------

    public int getPlayerID() {
        return playerID;
    }

    public int getStarships() {
        return starships;
    }

    public int getStarbases() {
        return starships;
    }

    public int getSector(){
        return sector;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setStarships(int starships) {
        this.starships = starships;
    }

    public void setStarbases(int starbases) {
        this.starbases = starbases;
    }

    public void  setSector(int sector) {
        this.sector = sector;
    }
    //------------------------------------------------------------------------------------------------------------------
    // Actions
    public void mobiliseToSector() {

    }

    /// ----------------------------------------------------------------------------------------------------------------

    public void attackTarget() {

    }
}
