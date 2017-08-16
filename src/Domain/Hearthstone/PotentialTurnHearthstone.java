package Domain.Hearthstone;

import Domain.Card;
import Domain.PotentialTurn;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Class that represents a turn, which contains a list of cards played and the
 * percentage chance that it could happen.
 */


public class PotentialTurnHearthstone implements PotentialTurn {

    double percentChance;
    List<Card> cards;

    public PotentialTurnHearthstone(double chance, List<Card> crds){
        this.percentChance = chance;
        this.cards = crds;
    }

    public double getPercentChance() {
        return percentChance;
    }

    public void setPercentChance(double percentChance) {
        this.percentChance = percentChance;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Chance of turn: " + percentChance);
        for(Card c : cards){
            sb.append(c.toString() + "\n");
        }
        return sb.toString();
    }


    /**
     * To be able to sort Potential turns in order of percentage chance.
     * @param o
     * @return
     */

    @Override
    public int compareTo(@NotNull PotentialTurn o) {
        if(this.percentChance > o.getPercentChance()) return -1;
        else if(this.percentChance == o.getPercentChance()) return 0;
        return 1;
    }
}
