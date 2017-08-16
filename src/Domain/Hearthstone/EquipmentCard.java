package Domain.Hearthstone;

/**
 * Created by noahr on 4/27/2017.
 */

public class EquipmentCard extends HearthstoneCard {

    int durability;

    public EquipmentCard(String name, String type, int cost, int durability){
        super(name, type, cost);
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Durability: " + durability + "\n");
        return sb.toString();
    }
}
