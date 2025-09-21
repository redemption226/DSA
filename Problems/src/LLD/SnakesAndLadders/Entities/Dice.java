package LLD.SnakesAndLadders.Entities;

public class Dice {

    public int rollDice() {
        int d = (int) (Math.random() * 10) % 6 + 1;
        System.out.println("Rolled Dice is " + d);
        return d;

    }

}
