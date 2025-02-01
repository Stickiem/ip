package Stickiem;

/**
 * Deals with making sense of the user command
 */
public class Parser {

    /**
     * Categorizes user command to different types, "bye",
     * "list", "mark", "delete", "add" or "find"
     *
     * @param command user command
     * @return type command type
     */
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
