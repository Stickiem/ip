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


}
