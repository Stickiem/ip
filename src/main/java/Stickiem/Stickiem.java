package Stickiem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Stickiem {
    private Ui ui;
    private Save save;
    private TaskList taskList;

    public Stickiem(String filePath) {
        this.ui = new Ui();
        this.save = new Save(filePath);
        this.taskList = new TaskList();

        try {
            ArrayList<String> initialValues = save.load();
            for (int i = 0; i < initialValues.size(); i++) {
                taskList.addTask(createTask(initialValues.get(i)));
            }
        } catch (StickiemCommandException e) {
            System.out.println(e.getMessage());
        }

    }

    public void run() {
        while(this.ui.getActivity()) {
            String userInput = this.ui.getUserInput();
            String type = Parser.parse(userInput);
            try {
                checkCommand(userInput);
            } catch (StickiemCommandException e) {
                System.out.println(e.getMessage());
                continue;
            }
            if(type.equals("bye")) {
                ui.exit();
            } else if (type.equals("list")) {
                this.ui.printOutput(this.taskList.getTaskDetails());
            } else if (type.equals("mark")) {
                String output = "";
                String[] details = userInput.split(" ");
                int index = Integer.parseInt(details[1]) - 1;
                Task currentTask = this.taskList.getTask(index);
                if (userInput.contains("unmark")) {
                    currentTask.unmarkStatus();
                    output += "OK, I've marked this task as not done yet:";

                } else {
                    currentTask.markStatus();
                    output += "Nice! I've marked this task as done:";
                }
                this.save.save(this.taskList.convertCommand());
                this.ui.printOutput(output + "\n" + currentTask.getDetails());
            } else if (type.equals("delete")) {
                String[] details = userInput.split(" ");
                int index = Integer.parseInt(details[1]) - 1;
                String output = this.taskList.removeTask(index);
                this.save.save(this.taskList.convertCommand());

                this.ui.printOutput(output);
            } else if (type.equals("add")) {
                try {
                    Task currentTask = createTask(userInput);
                    String output = taskList.addTask(currentTask);
                    this.save.save(this.taskList.convertCommand());

                    this.ui.printOutput(output);

                } catch (StickiemCommandException e) {
                    System.out.println(e.getMessage());
                }

            } else {
                ui.printOutput("Invalid command");
            }

        }
    }





public static void main(String[] args) {
    new Stickiem("stickiem.txt").run();
}
/*
    public static void main(String[] args) {
        String output = "____________________________________________________________";
        output += "\nHello! I'm Stickiem!\nWhat can I do for you?";
        output += "\n____________________________________________________________";
        System.out.println(output);
        Scanner input = new Scanner(System.in);
        List<Task> storage = new ArrayList<Task>();

        Save file = new Save("Stickiem.txt");
        ArrayList<String> initialValue = file.load();
        try {
            for (int i = 0; i < initialValue.size(); i++) {
                storage.add(createTask(initialValue.get(i)));
            }
        } catch (StickiemCommandException e) {
            System.out.println(e.getMessage());
        }

        while (true) {
            output = "";
            String userInput = input.nextLine();
            if (userInput.equals("bye")) {
                break;

            } else if (userInput.contains("mark")) {
                String[] details = userInput.split(" ");
                int index = Integer.parseInt(details[1]) - 1;
                Task currentTask = storage.get(index);
                if (userInput.contains("unmark")) {
                    currentTask.unmarkStatus();
                    output += "OK, I've marked this task as not done yet:";

                } else {
                    currentTask.markStatus();
                    output += "Nice! I've marked this task as done:";
                }
                initialValue.set(index, currentTask.getCommand());
                file.save(initialValue);
                output += "\n" + currentTask.getDetails();


            } else if(userInput.contains("delete")) {
                String[] details = userInput.split(" ");
                int index = Integer.parseInt(details[1]) - 1;
                Task currentTask = storage.get(index);

                output = "Noted. I've removed this task:" + currentTask.getDetails();
                storage.remove(currentTask);
                initialValue.remove(index);
                file.save(initialValue);
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
                    initialValue.add(currentTask.getCommand());
                    file.save(initialValue);
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
*/
public static Task createTask(String userInput) throws StickiemCommandException {
    boolean markings = false;
    if(userInput.charAt(0) == 'X') {
        markings = true;
    }

    if (userInput.contains("todo")) {
        //String name = userInput.replace("todo", "");
        String name = userInput.substring(userInput.indexOf("todo") + 5);

        ToDo newItem = new ToDo(name, markings);
        return newItem;
    } else if (userInput.contains("deadline")) {
        //String name = userInput.replace("deadline", "");
        String name = userInput.substring(userInput.indexOf("deadline") + 9);

        int index = name.indexOf("/by");
        String date = name.substring(index + 3);
        name = name.substring(0, index);

        Deadline newItem = new Deadline(name, date, markings);
        return newItem;
    } else if (userInput.contains("event")) {
        //String name = userInput.replace("event", "");
        String name = userInput.substring(userInput.indexOf("event") + 6);
        int indexFrom = name.indexOf("/from");
        int indexTo = name.indexOf("/to");
        String startDate = name.substring(indexFrom + 5, indexTo);
        String endDate = name.substring(indexTo + 3);
        name = name.substring(0, indexFrom);

        Event newItem = new Event(name, startDate, endDate, markings);
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


