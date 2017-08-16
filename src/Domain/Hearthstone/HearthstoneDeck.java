package Domain.Hearthstone;

import Domain.Deck;
import Domain.Hearthstone.HearthstoneCard;

import java.util.*;

/**
 * Created by noahr on 4/28/2017.
 */
public class HearthstoneDeck implements Deck<HearthstoneCard> {

    List<HearthstoneCard> cards;

    public HearthstoneDeck(List<HearthstoneCard> crds){
        this.cards = crds;
    }


    /**
     * return the top x cards from the deck
     * @param num = the number of cards to draw
     * @return a list of the drawn cards
     */

    @Override
    public List<HearthstoneCard> draw(int num){
        List<HearthstoneCard> result = new ArrayList();
        for(int i = 0; i < num; i++){
            result.add(cards.get(i));
        }
        return result;
    }


    /**
     * Shuffle the deck
     */

    @Override
    public void shuffle(){
        Collections.shuffle(cards);
    }


    /**
     * Add a single card to the deck
     * @param card = the card to be added
     */

    @Override
    public void addCard(HearthstoneCard card){
        cards.add(card);
    }


    /**
     * Remove any number of a specific card by name from the deck
     * @param name = name of card to remove
     * @param num = the number of that card you want to remove
     */

    @Override
    public void removeSpecificCard(String name, int num){
        int count = 0;
        for(HearthstoneCard c : cards){
            if(count >= num) return;
            if(c.getName().equalsIgnoreCase(name)){
                cards.remove(name);
                count++;
            }
        }
    }


    @Override
    public List<HearthstoneCard> getCards() {
        return cards;
    }

    public void setCards(List<HearthstoneCard> cards) {
        this.cards = cards;
    }


    /**
     * Format the deck into a single formatted string containing the data on all
     * the cards contained within the deck
     * @return a single formatted string
     */

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(HearthstoneCard c : cards){
            sb.append(c.toString());
            //sb.append("\n");
        }
        return sb.toString();
    }
}
