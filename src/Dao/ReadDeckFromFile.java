package Dao;

import Domain.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by noahr on 4/27/2017.
 */

public class ReadDeckFromFile implements ReadDeck {


    /**
     * Read the stored deck from a local file.  Parse it into a list of strings,
     * where each string represents a single card.
     * @return a list of strings, where each string is a single card.
     */

    @Override
    public List<String> readDeck() {
        List<String> cardStrings = new ArrayList<>();
        final String FILE_NAME = "C:\\Users\\noahr\\Desktop\\Cards.txt";
        BufferedReader br = null;
        FileReader fr = null;

        try{
            fr = new FileReader(FILE_NAME);
            br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                cardStrings.add(line);
            }
        }
        catch(Exception e){
            System.out.println("Error reading from file!");
        }
        return cardStrings;
    }
}
