//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Sector sector1 = new Sector("Sector 1");
        Sector sector2 = new Sector("Sector 2");

        // 1. Create a "Player 1" fleet with 1 starbase and 3 ships in "Sector 1"
        // Setting up Player 1
        Starbases player1Starbase = new Starbases("Player 1 Starbase", sector1);
        Fleets player1 = new Fleets(1,player1Starbase);
        player1Starbase.setFleets(player1);

        Starships player1StarshipA = new Starships(player1, "Player 1 Starship A", sector1);
        Starships player1StarshipB = new Starships(player1, "Player 1 Starship B", sector1);
        Starships player1StarshipC = new Starships(player1, "Player 1 Starship C", sector1);

        player1.addStarship(player1StarshipA);
        player1.addStarship(player1StarshipB);
        player1.addStarship(player1StarshipC);

        System.out.println("Created Player 1 with 1 starbase and 3 starships");
        System.out.println("Name of Starbase: " + player1.getStarbases());
        System.out.println("List of starships:" + player1.getStarships());

        // 2. Create a "Player 2" fleet with 1 starbase and 3 ships in "Sector 2"
        // Setting up Player 2
        Starbases player2Starbase = new Starbases("Player 2 Starbase", sector2);
        Fleets player2 = new Fleets(2,player2Starbase);
        player2Starbase.setFleets(player2);

        Starships player2StarshipA = new Starships(player2, "Player 2 Starship A", sector2);
        Starships player2StarshipB = new Starships(player2, "Player 2 Starship B", sector2);
        Starships player2StarshipC = new Starships(player2, "Player 2 Starship C", sector2);

        player2.addStarship(player2StarshipA);
        player2.addStarship(player2StarshipB);
        player2.addStarship(player2StarshipC);

        System.out.println("Created Player 2 with 1 starbase and 3 starships");
        System.out.println("Name of Starbase: " + player2.getStarbases());
        System.out.println("List of starships:" + player2.getStarships());

        // 3. Move all ships in the "Player 1" fleet to "Sector 2"
        player1.moveAllToSector(sector2);
        System.out.println("Moved all ships in Player 1 fleet to Sector 2");

        // 4. Docks 2 ships from the "Player 2" fleet into the "Player 2" starbase
        player2StarshipA.setDockedAtStarbase(player2Starbase);
        player2StarshipB.setDockedAtStarbase(player2Starbase);

        // 5. Selects one ship from the “Player 1” fleet and use it to attack the remaining undocked starship from the "Player 2" fleet with the "Player 2" starbase then repairs it.
        player1StarshipA.attackStarshipTarget(player2StarshipC);
        player1StarshipA.attackStarshipTarget(player2StarshipC);
        player1StarshipA.attackStarshipTarget(player2StarshipC);

        // 6. Docks the remaining undocked starship in the “Player 2” fleet with the “Player 2” starbase then repairs it.
        player2StarshipC.setDockedAtStarbase(player2Starbase);
        player2StarshipC.repair();

        // 7. Commands all starships in the “Player 1” fleet to attack the “Player 2” starbase (repeatedly, until the “Player 2” starbase is destroyed).
        while (player2Starbase.getCurrentHealth() > 0) {
            player1StarshipA.attackStarbaseTarget(player2Starbase);
            player1StarshipB.attackStarbaseTarget(player2Starbase);
            player1StarshipC.attackStarbaseTarget(player2Starbase);
        }
        System.out.println("Player 2 Starbase is being destroyed");
        System.out.println("PLayer 1 Wins");

    }

    // My Task
    // 1. Create a "Player 1" fleet with 1 starbase and 3 ships in "Sector 1"
    // 2. Create a "Player 2" fleet with 1 starbase and 3 ships in "Sector 2"
    // 3. Move all ships in the "Player 1" fleet to "Sector 2"
    // 4. Docks 2 ships from the "Player 2" fleet into the "Player 2" starbase
    // 5. Selects one ship from the “Player 1” fleet and use it to attack the remaining undocked starship from the "Player 2" fleet with the "Player 2" starbase then repairs it.
    // 6. Docks the remaining undocked starship in the “Player 2” fleet with the “Player 2” starbase then repairs it.
    // 7. Commands all starships in the “Player 1” fleet to attack the “Player 2” starbase (repeatedly, until the “Player 2” starbase is destroyed).

}
