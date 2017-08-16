package Domain.Hearthstone;

import Domain.Card;
import Domain.Deck;
import Domain.Game;
import Domain.Hearthstone.HearthstoneCard;
import Domain.Hearthstone.HearthstoneDeck;
import Domain.Hearthstone.PotentialTurnHearthstone;
import Domain.PotentialTurn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class that represents a game of Hearthstone.  Contains functionality that is outside the scope
 * of the deck object.
 */

public class HearthstoneGame implements Game {

    HearthstoneDeck deck;
    Map<String, Double> percentagesCache;
    List<PotentialTurn> plays;

    public HearthstoneGame(HearthstoneDeck dk){
        this.deck = dk;
        this.percentagesCache = new HashMap<>();
    }


    /**
     * Given an amount of mana, get all the possible cards a player could play this turn.
     * @param mana = the amount of mana the player has access to
     * @param handSize = the number of cards in the player's hand
     * @return a set of all the potential plays
     */

    public void generatePlays(int mana, int handSize){
        this.plays = powerSet(deck.getCards(), deck.getCards().size(), mana, handSize);
    }


    /**
     * Method to calculate the powerset of a deck of cards
     * @param set = the list of cards in the deck
     * @param size = the size of that list
     */

    private List<PotentialTurn> powerSet(List<HearthstoneCard> set, int size, int mana, int hand) {
        List<PotentialTurn> resultSet = new ArrayList<>();
        List<Card> res = new ArrayList<>();
        double pSetSize = Math.pow(2, size);
        int counter;
        int j;
        int sum;
        double chance;

        for(counter = 0; counter < pSetSize; counter++){
            sum = 0;
            chance = 1;
            for(j = 0; j < size; j++){
                if((counter & (1 << j)) != 0){
                    HearthstoneCard c = set.get(j);
                    if(sum + c.getCost() > mana || res.size() >= hand){
                        res = new ArrayList<>();
                        break;
                    }
                    else{
                        sum += c.getCost();
                        chance *= chanceOfDrawing(c.getName());
                        res.add(c);
                    }
                }
            }
            if(!res.isEmpty()) {
                PotentialTurn pt = new PotentialTurnHearthstone(chance * 100, res);
                resultSet.add(pt);
                res = new ArrayList<>();
            }
        }
        return resultSet;
    }


    /**
     * Calculate the chance of drawing a specific card from the deck
     * @param cardName = the name of the card you are interested in
     * @return the percentage chance of drawing the inputted card
     */

    public double chanceOfDrawing(String cardName){
        double result = 0.0;
        if(percentagesCache.containsKey(cardName)){
            result = percentagesCache.get(cardName);
        }
        else {
            double totalNumOfCards = deck.getCards().size();
            double numOfSpecificCard = 0;
            for (HearthstoneCard c : deck.getCards()) {
                if (c.getName().equalsIgnoreCase(cardName)) numOfSpecificCard++;
            }
            result =  numOfSpecificCard / totalNumOfCards;
            percentagesCache.put(cardName, result);
        }
        return result;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(HearthstoneDeck deck) {
        this.deck = deck;
    }

    public Map<String, Double> getPercentagesCache() {
        return percentagesCache;
    }

    public void setPercentagesCache(Map<String, Double> percentagesCache) {
        this.percentagesCache = percentagesCache;
    }


    /**
     * Return a list of the potential plays that could be made from the generated options.
     * The result is filtered to only include options using a specific number of cards.
     * @param cards = the number of cards in a play
     * @return a list of potential plays
     */

    @Override
    public List<PotentialTurn> getPlays(int cards) {
        List<PotentialTurn> results = plays.stream().filter(turn -> turn.getCards().size() == cards).collect(Collectors.toList());
        return results;
    }
}
