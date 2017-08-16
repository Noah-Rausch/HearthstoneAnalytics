package App;

import Controller.OperationController;
import Service.Hearthstone.AccessCardsService;
import View.ConsoleView;

/**
 * Created by noahr on 4/27/2017.
 */
public class App {

    public static void main( String[] args ){

        AccessCardsService service = new AccessCardsService();
        ConsoleView view = new ConsoleView();
        OperationController game = new OperationController(service, view);
        game.InitiatePrompt();
    }
}
