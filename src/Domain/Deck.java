package Domain;

import java.util.List;

/**
 * Outline common functionality associated with a deck
 */

public interface Deck<T> {

    public List<T> draw(int num);

    public void shuffle();

    public void addCard(T card);

    public void removeSpecificCard(String cardName, int num);

    public List<T> getCards();
}
