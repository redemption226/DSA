package SnakesAndLadders;

import SnakesAndLadders.Entities.Board;
import SnakesAndLadders.Entities.Dice;
import SnakesAndLadders.Entities.Player;

import java.util.Queue;

public class Game {

    Board board;
    Queue<Player> players;
    Dice dice;


    public Game(int dimensions, Queue<Player> players) {
        board = new Board(dimensions);
        dice = new Dice();
        this.players = players;
    }

    public void startGame() {

        System.out.println("Player Turn: " + players.peek().getName());
        board.printState();

    }

    public int rollDice() {
        return dice.rollDice();
    }
}
