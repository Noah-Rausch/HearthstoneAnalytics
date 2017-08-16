package Domain.Hearthstone;

import Domain.Card;

/**
 * Created by noahr on 4/27/2017.
 */
public class HearthstoneCard extends Card {
    int cost;
    String type;

    public HearthstoneCard(String name, String typ, int cost) {
        super(name);
        this.cost = cost;
        this.type = typ;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + super.getName() + "\n");
        sb.append("Type: " + type + "\n");
        sb.append("Cost: " + cost + "\n");
        return sb.toString();
    }
}
