package Exceptions;

/**
 * Class that handles the the task of displaying error messages to the user.
 */

public class ErrorView {

    public ErrorView(){

    }

    public void wrongInput(){
        System.out.println("Incorrect input format");
    }

    public void wrongArgNum(){
        System.out.println("Incorrect number of arguments");
    }
}
