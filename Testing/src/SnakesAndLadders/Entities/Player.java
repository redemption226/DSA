package SnakesAndLadders.Entities;

public class Player {
    String name;
    double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    int currentPos;

    public Player(String name) {
        this.name = name;
        this.score = 0.0;
        currentPos = 0;
    }

    public void setPosition(int pos) {
        this.currentPos= pos;
    }

    public int getPosition() {
        return this.currentPos;
    }

    public void move(int jumps) {

    }

}
