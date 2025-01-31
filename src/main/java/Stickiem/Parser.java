package Stickiem;

public class Parser {


    public static String parse(String command) {
        String type = "";
        if (command.equals("bye")) {
            type = "bye";
        } else if (command.equals("list")) {
            type = "list";
        } else if (command.contains("mark")) {
            type = "mark";
        } else if (command.contains("delete")) {
            type = "delete";
        } else if (command.contains("todo") || command.contains("deadline") || command.contains("event")) {
            type = "add";
        }

        return type;
    }


}
