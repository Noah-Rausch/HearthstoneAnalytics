package Domain;

import java.util.List;

/**
 * Outline the functionality required of a game.
 */

public interface Game {

    public void generatePlays(int mana, int handSize);

    public double chanceOfDrawing(String cardName);

    public Deck getDeck();

    public List<PotentialTurn> getPlays(int cards);
}
