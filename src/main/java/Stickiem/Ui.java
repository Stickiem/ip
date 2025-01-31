package Stickiem;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;
    private String output;
    private boolean isActive;

    public Ui() {
        this.scanner = new Scanner(System.in);
        this.isActive = true;
        this.output = "____________________________________________________________";
        this.output += "\nHello! I'm Stickiem!\nWhat can I do for you?";
        this.output += "\n____________________________________________________________";
        System.out.println(output);
    }

    public void exit() {
        this.output = "bye";
        this.isActive = false;
    }

    public boolean getActivity() {
        return this.isActive;
    }

    public String getUserInput() {
        return this.scanner.nextLine();
    }

    public void printOutput(String response) {
        this.output = "____________________________________________________________\n";;
        this.output += response;
        this.output += "\n____________________________________________________________";;
        System.out.println(output);
    }
}
