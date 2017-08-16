package Domain.Hearthstone;

import Domain.Hearthstone.HearthstoneCard;

/**
 * Created by noahr on 4/27/2017.
 */

public class SpellCard extends HearthstoneCard {

    String effect;

    public SpellCard(String name, String type, int cost, String text){
        super(name, type, cost);
        this.effect = text;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Effect: " + effect + "\n");
        return sb.toString();
    }
}
