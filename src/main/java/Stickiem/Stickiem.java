package stickiem;
/**
 * The main program to get the response from the chatbot.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stickiem {
    private Save save;
    private TaskList taskList;

    /**
     * Sets up Stickiem chatbot.
     * Loads saved data if any.
     *
     * @param filePath location of file storage
     */
    public Stickiem(String filePath) {
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

    /**
     *Returns response from Stickiem.
     *
     * @param userInput command given by the user.
     * @return response task generated.
     */
    public String run(String userInput) {
            String response = "";
            String type = Parser.parse(userInput);
            try {
                checkCommand(userInput);
            } catch (StickiemCommandException e) {
                System.out.println(e.getMessage());
            }

            switch (type) {
            case "bye" -> {
                response = "";
            }
            case "list" -> {
                response = this.taskList.getTaskDetails();
            }
            case "mark" -> {
                String[] details = userInput.split(" ");
                int index = Integer.parseInt(details[1]) - 1;
                Task currentTask = this.taskList.getTask(index);
                if (userInput.contains("unmark")) {
                    currentTask.unmarkStatus();
                    response += "OK, I've marked this task as not done yet:";

                } else {
                    currentTask.markStatus();
                    response += "Nice! I've marked this task as done:";
                }
                this.save.save(this.taskList.convertCommand());
                response += "\n" + currentTask.getDetails();
            }
            case "delete" -> {
                String[] details = userInput.split(" ");
                int index = Integer.parseInt(details[1]) - 1;
                response =  this.taskList.removeTask(index);
                this.save.save(this.taskList.convertCommand());

            }
            case "add" -> {
                try {
                    Task currentTask = createTask(userInput);
                    response =  taskList.addTask(currentTask);
                    this.save.save(this.taskList.convertCommand());

                } catch (StickiemCommandException e) {
                    System.out.println(e.getMessage());
                }
            }
            case "find" -> {
                int index = userInput.indexOf("find");
                String keyword = userInput.substring(index + 5);


                response =  "Here are the matching tasks in your list:" + new TaskList(taskList.getTasks(keyword)).getTaskDetails();


            }
            case "remind" -> {
                response =  "Here are some of your uncompleted tasks reminders:" + taskList.getUnmarked();
            }
            default -> {
                response = "Invalid command";
            }
            }


        return response;
    }


    /**
     * Returns the task created based on the user input.
     *
     * @param userInput command given by the user.
     * @return newItem task generated.
     * @throws StickiemCommandException if command does not exists.
     */

public static Task createTask(String userInput) throws StickiemCommandException {
    boolean isMarked = false;
    if(userInput.charAt(0) == 'X') {
        isMarked = true;
    }

    if (userInput.contains("todo")) {
        String name = userInput.substring(userInput.indexOf("todo") + 5);

        ToDo newItem = new ToDo(name, isMarked);
        return newItem;
    } else if (userInput.contains("deadline")) {
        String name = userInput.substring(userInput.indexOf("deadline") + 9);

        int index = name.indexOf("/by");
        String date = name.substring(index + 3);
        name = name.substring(0, index);

        Deadline newItem = new Deadline(name, date, isMarked);
        return newItem;
    } else if (userInput.contains("event")) {
        String name = userInput.substring(userInput.indexOf("event") + 6);
        int indexFrom = name.indexOf("/from");
        int indexTo = name.indexOf("/to");
        String startDate = name.substring(indexFrom + 5, indexTo);
        String endDate = name.substring(indexTo + 3);
        name = name.substring(0, indexFrom);

        Event newItem = new Event(name, startDate, endDate, isMarked);
        return newItem;
    } else {
        throw new StickiemCommandException("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }




}

    /**
     *  Checks the validity of user input.
     *
     * @param userInput command given by the user.
     * @throws StickiemCommandException if no input detected or detail omitted.
     */
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


