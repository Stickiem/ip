import java.io.PrintWriter;
import java.util.Scanner;

public class Stickiem {
    public static void main(String[] args) {
        String output = "____________________________________________________________";
        output += "\nHello! I'm Stickiem!\nWhat can I do for you?";
        output += "\n____________________________________________________________";
        System.out.println(output);
        Scanner input = new Scanner(System.in);
        while(true) {
            String userInput = input.nextLine();
            if(userInput.equals("bye")) {
                break;
            } else {
                output = userInput;
            }
            output += "\n____________________________________________________________";
            System.out.println(output);
        }
        output = "Bye. Hope to see you again soon!";
        output += "\n____________________________________________________________";
        System.out.println(output);

    }
}