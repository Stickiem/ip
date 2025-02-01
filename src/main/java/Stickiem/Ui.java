package Stickiem;
/**
 * Deals with the interaction between user.
 */

import java.util.Scanner;

public class Ui {
    private Scanner scanner;
    private String output;
    private boolean isActive;

    /**
     * Sets up the Ui and welcome message.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
        this.isActive = true;
        this.output = "____________________________________________________________";
        this.output += "\nHello! I'm Stickiem!\nWhat can I do for you?";
        this.output += "\n____________________________________________________________";
        System.out.println(output);
    }

    /**
     * Close the active status of the Ui.
     * Prints "bye".
     */
    public void exit() {
        this.output = "bye";
        this.isActive = false;
    }

    public boolean getActivity() {
        return this.isActive;
    }

    /**
     * Takes in user's command
     *
     * @return this.scanner.nextLine() user input
     */
    public String getUserInput() {
        return this.scanner.nextLine();
    }

    /**
     * Displays output to user.
     *
     * @param response output based on user command.
     */
    public void printOutput(String response) {
        this.output = "____________________________________________________________\n";;
        this.output += response;
        this.output += "\n____________________________________________________________";;
        System.out.println(output);
    }
}
