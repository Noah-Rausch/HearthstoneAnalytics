package View;

import java.util.List;
import java.util.Scanner;

/**
 * Created by noahr on 4/28/2017.
 */

public class ConsoleView<T> {

    // User operation options
    public static String OPTIONS = "options";
    public static String DRAW = "draw";
    public static String DISPLAY = "display";
    public static String CHANCE = "chance";
    public static String FILTER = "filter";
    public static String EXIT = "exit";

    Scanner scanner = new Scanner(System.in);
    public ConsoleView(){

    }


    /**
     * Displays the root menu to the user, from which they can do several things
     */

    public void displayRootMenu(){
        System.out.println("\n\n");
        System.out.println("Enter instruction:");
        System.out.println("Type " + DRAW +  " to draw a card");
        System.out.println("Type "+ OPTIONS +" and two numbers, the first number is mana and the second is cards in hand");
        System.out.println("Type "+ FILTER +" and a number to filter potential plays containing that number of cards");
        System.out.println("Type " + DISPLAY +" to show the current deck contents");
        System.out.println("Type " + CHANCE +" a card name to display the chances of drawing that card");
        System.out.println("Type " + EXIT +" to exit");
        System.out.println("\n\n");
    }


    public void displayInputError(){
        System.out.println("Invalid input");
    }

    public void displayComplete(){
        System.out.println("Calculating complete");
    }


    /**
     * Get user input using scanner
     * @return String user input
     */

    public String readInput(){
        String choice = scanner.nextLine();
        return choice;
    }


    /**
     * Display to console a list of items
     * @param items =  list of items to be displayed
     */

    public void displayList(List<T> items){
        for(T item : items){
            System.out.println(item.toString());
        }
        System.out.println("\n");
    }


    public void displayPercent(double doub){
        System.out.println(doub + "%");
    }

    public void displayPercentAsInt(double doub){
        System.out.println("Chance of turn: " + (int)doub + "%");
    }


    /**
     * Display to console the chance of drawing a specific card
     * @param card = the card you are interested in
     * @param perc = the percentage chance of drawing said card
     */

    public void displayCardChance(String card, double perc){
        System.out.println("Chance of drawing " + card + " is " + (int)perc + "%");
    }
}
