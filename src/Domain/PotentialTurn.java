package Domain;

import java.util.List;

/**
 * Outline the functionality required of an object that represents a possible play
 */

public interface PotentialTurn extends Comparable<PotentialTurn> {

    public double getPercentChance();

    public List<Card> getCards();

    public int compareTo(PotentialTurn pt);
}
