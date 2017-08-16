package Domain;

/**
 * Created by noahr on 4/27/2017.
 */

public abstract class Card {
    String name;

    public Card(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
