package LLD.SnakesAndLadders.Entities;

public abstract class BoardEntity {

    int startPos;
    int endPos;

    BoardEntity(int startPos, int endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public void move(Player player) {
        player.setPosition(endPos);
    }
}
