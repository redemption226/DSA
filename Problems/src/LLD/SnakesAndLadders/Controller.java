package LLD.SnakesAndLadders;

import LLD.SnakesAndLadders.Entities.Player;

import java.util.LinkedList;
import java.util.Queue;

public class Controller {

    public static void main(String[] args) {

        Player p1 = new Player("Himanshu");
        Player p2 = new Player("Nehal");

        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.add(p1);
        playerQueue.add(p2);

        Game game = new Game(10, playerQueue);


        game.startGame();

        game.rollDice();
    }




}
