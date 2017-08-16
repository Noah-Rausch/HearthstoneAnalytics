package Domain.Hearthstone;

/**
 * Created by noahr on 4/27/2017.
 */

public class CreatureCard extends HearthstoneCard {

    int attack;
    int defense;

    public CreatureCard(String name, String type, int cost, int attack, int defense){
        super(name, type, cost);
        this.attack = attack;
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Attack: " + attack + "\n");
        sb.append("Defense: " + defense + "\n");
        return sb.toString();
    }
}
