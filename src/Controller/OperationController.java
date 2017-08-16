package Controller;

import Domain.*;
import Domain.Hearthstone.HearthstoneGame;
import Service.Hearthstone.AccessCardsService;
import View.ConsoleView;

import java.util.Collections;
import java.util.List;


/**
 * Controller class to deal with initiating operations based on user input
 */

public class OperationController {

    private AccessCardsService cardsService;
    private Game game;
    private ConsoleView view;

    public OperationController(AccessCardsService serv, ConsoleView v){
        this.cardsService = serv;
        this.view = v;
        game = new HearthstoneGame(cardsService.getDeck());
    }


    /**
     * Initiate the loop where the user may input their desired instruction.
     */

    public void InitiatePrompt(){
        String instruction = "";
        while(!instruction.equalsIgnoreCase("exit")){
            view.displayRootMenu();
            instruction = view.readInput();
            executeInstruction(instruction);
        }
    }


    /**
     * Executes functions based on user input.
     * @param input = string provided by user
     */

    public void executeInstruction(String input){

        String[] splited = input.split("\\s+");
        if(splited.length < 1) return;

        // Draw a card
        if(splited[0].equalsIgnoreCase(view.DRAW)){

            if(splited.length != 2) view.displayInputError();
            else {
                int quantity = Integer.parseInt(splited[splited.length - 1]);
                List<Card> draws = game.getDeck().draw(quantity);
                view.displayList(draws);
            }
        }

        // Generate potential plays
        else if(splited[0].equalsIgnoreCase(view.OPTIONS)) {
            if (splited.length != 3) view.displayInputError();
            else {
                int hand = Integer.parseInt(splited[splited.length - 1]);
                int quantity = Integer.parseInt(splited[splited.length - 2]);
                game.generatePlays(quantity, hand);
                view.displayComplete();
            }
        }

        // Filter results based on a specific number of cards
        else if(splited[0].equalsIgnoreCase(view.FILTER)){
            if(splited.length != 2){
                view.displayInputError();
            }
            else {
                int num = Integer.parseInt(splited[1]);
                List<PotentialTurn> plays = game.getPlays(num);
                Collections.sort(plays);
                for (PotentialTurn pt : plays) {
                    view.displayPercentAsInt(pt.getPercentChance());
                    view.displayList(pt.getCards());
                }
            }
        }

        // Show the deck
        else if(splited[0].equalsIgnoreCase(view.DISPLAY)){
            view.displayList(game.getDeck().getCards());
        }

        // Show chance of a specific card being drawn
        else if(splited[0].equalsIgnoreCase(view.CHANCE)){
            if(splited.length != 2) view.displayInputError();
            else {
                String card = splited[splited.length - 1];
                double result = game.chanceOfDrawing(card) * 100;
                view.displayCardChance(card, result);
            }
        }

        // Exit program
        else if(splited[0].equalsIgnoreCase(view.EXIT)){
            System.out.println("Exiting...");
            System.exit(0);
        }
    }
}
