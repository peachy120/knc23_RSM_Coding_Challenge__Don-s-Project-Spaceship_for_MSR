//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Starbases starbases = new Starbases(500,20);

        Starships starships = new Starships(30, 10, 10, 100);

        Fleets f1 = new Fleets(1, 3, 1, 1);
        Fleets f2 = new Fleets(2, 3,1, 2);
    }
}
