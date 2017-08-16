package Service.Hearthstone;

import Dao.ReadDeck;
import Dao.ReadDeckFromFile;
import Domain.Hearthstone.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to handle the task of getting the stored deck and constructing a deck.
 */

public class AccessCardsService {

    ReadDeck reader;

    public AccessCardsService(){
        reader = new ReadDeckFromFile();
    }
    public AccessCardsService(ReadDeck rdr){
        this.reader = rdr;
    }


    /**
     * Using the current ReadDeck object, read the stored deck as a list of strings,
     * convert it into a usable deck object.
     * @return a Deck object to be utilized by the caller.
     */

    public HearthstoneDeck getDeck(){
        List<HearthstoneCard> cards = new ArrayList<>();
        List<String> contents = reader.readDeck();
        for(String s : contents){
            Scanner scan = new Scanner(s);
            while(scan.hasNext()){
                HearthstoneCard card = null;
                String type = scan.next();
                String name = scan.next();
                int cost = scan.nextInt();
                switch (type){
                    case "creature":
                        int atk = scan.nextInt();
                        int def = scan.nextInt();
                        card = new CreatureCard(name, type, cost, atk, def);
                        break;
                    case "spell":
                        String eff = "Dummy Text";
                        card = new SpellCard(name, type, cost, eff);
                        break;
                    case "equipment":
                        int dur = scan.nextInt();
                        card = new EquipmentCard(name, type, cost, dur);
                        break;
                }
                cards.add(card);
            }
        }
        return new HearthstoneDeck(cards);
    }
}
