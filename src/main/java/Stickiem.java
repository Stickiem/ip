
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stickiem {
    public static void main(String[] args) {
        String output = "____________________________________________________________";
        output += "\nHello! I'm Stickiem!\nWhat can I do for you?";
        output += "\n____________________________________________________________";
        System.out.println(output);
        Scanner input = new Scanner(System.in);
        List<Task> storage = new ArrayList<Task>();
        while(true) {
            output = "";
            String userInput = input.nextLine();
            if(userInput.equals("bye")) {
                break;

            } else if(userInput.equals("list")) {
                int len = storage.size();

                for(int i = 0; i < len; i++) {
                    int index = i + 1;
                    output += "\n" + index + ". " + storage.get(i).getName() ;

                }
            } else {

                Task newItem = new Task();
                newItem.setName(userInput);
                storage.add(newItem);
                output = "added: " + userInput;
            }
            output += "\n____________________________________________________________";
            System.out.println(output);
        }
        output = "Bye. Hope to see you again soon!";
        output += "\n____________________________________________________________";
        System.out.println(output);

    }
}