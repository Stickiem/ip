
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

            } else if(userInput.contains("mark")) {
                String[] details = userInput.split(" ");
                Task currentTask = storage.get(Integer.parseInt(details[1]) - 1);
                if(userInput.contains("unmark")) {
                    currentTask.unmarkStatus();
                    output += "OK, I've marked this task as not done yet:";

                } else {
                    currentTask.markStatus();
                    output += "Nice! I've marked this task as done:";
                }
                output += "\n" + currentTask.getDetails();



            }  else if(userInput.equals("list")) {
                int len = storage.size();

                for(int i = 0; i < len; i++) {
                    int index = i + 1;
                    Task currentTask = storage.get(i);
                    output += "\n" + index + "."  + currentTask.getDetails();

                }
            } else {

                Task newItem = new Task(userInput);
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