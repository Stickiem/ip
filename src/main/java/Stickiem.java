
import java.util.ArrayList;
import java.util.Arrays;
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
        while (true) {
            output = "";
            String userInput = input.nextLine();
            if (userInput.equals("bye")) {
                break;

            } else if (userInput.contains("mark")) {
                String[] details = userInput.split(" ");
                Task currentTask = storage.get(Integer.parseInt(details[1]) - 1);
                if (userInput.contains("unmark")) {
                    currentTask.unmarkStatus();
                    output += "OK, I've marked this task as not done yet:";

                } else {
                    currentTask.markStatus();
                    output += "Nice! I've marked this task as done:";
                }
                output += "\n" + currentTask.getDetails();


            } else if(userInput.contains("delete")) {
                String[] details = userInput.split(" ");
                Task currentTask = storage.get(Integer.parseInt(details[1]) - 1);

                output = "Noted. I've removed this task:" + currentTask.getDetails();
                storage.remove(currentTask);
                output += "\nNow you have " + storage.size() + " tasks in the list.";

            } else if (userInput.equals("list")) {
                int len = storage.size();

                for (int i = 0; i < len; i++) {
                    int index = i + 1;
                    Task currentTask = storage.get(i);
                    output += "\n" + index + "." + currentTask.getDetails();

                }
            } else {
                try {
                    checkCommand(userInput);
                    Task currentTask = createTask(userInput);
                    storage.add(currentTask);
                    int len = storage.size();

                    output = "Got it. I've added this task: \n" + storage.get(len - 1).getDetails();
                    output += "\nNow you have " + len + " tasks in the list.";
                } catch (StickiemCommandException e) {
                    System.out.println(e.getMessage());
                }

            }
            output += "\n____________________________________________________________";
            System.out.println(output);
        }
        output = "Bye. Hope to see you again soon!";
        output += "\n____________________________________________________________";
        System.out.println(output);

    }

    public static Task createTask(String userInput) throws StickiemCommandException {


        if (userInput.contains("todo")) {
            String name = userInput.replace("todo", "");
            ToDo newItem = new ToDo(name);
            return newItem;
        } else if (userInput.contains("deadline")) {
            String name = userInput.replace("deadline", "");

            int index = name.indexOf("/by");
            String date = name.substring(index + 3);
            name = name.substring(0, index);

            Deadline newItem = new Deadline(name, date);
            return newItem;
        } else if (userInput.contains("event")) {
            String name = userInput.replace("event", "");
            int indexFrom = name.indexOf("/from");
            int indexTo = name.indexOf("/to");
            String startDate = name.substring(indexFrom + 5, indexTo);
            String endDate = name.substring(indexTo + 3);
            name = name.substring(0, indexFrom);

            Event newItem = new Event(name, startDate, endDate);
            return newItem;
        } else {
            throw new StickiemCommandException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }


    }

    public static void checkCommand(String userInput) throws StickiemCommandException {
        if(userInput.isEmpty()) {
            throw new StickiemCommandException("Ehhh, no input detected");
        } else{
            List<String> types = Arrays.asList("todo", "deadline", "event");
            for(int i = 0; i<types.size(); i++){
                String check = userInput.replace(types.get(i), "");
                if(check.isEmpty()) {
                    throw new StickiemCommandException("OOPS!!! The description of a " + types.get(i) + " cannot be empty");
                }
            }

        }
    }





}
