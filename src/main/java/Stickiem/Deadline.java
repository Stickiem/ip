package stickiem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents task with deadlines.
 */
public class Deadline extends Task {
    private LocalDate endDate;

    public Deadline(String name, String endDate, boolean status) {
        super(name, status);
        endDate = endDate.trim();
        this.endDate = LocalDate.parse(endDate);
    }

    @Override
    public String getDetails() {
        String marking = this.isDone ? "X" : " ";
        return "[D][" + marking + "] " + this.name + "(by: "+ this.endDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    @Override
    public String getType() {

        return "deadline";
    }

    @Override
    public String getCommand() {
        String marking = isDone ? "X" : "";
        return marking + " " + this.getType() + " " + this.name + "/by " + this.endDate.toString();
        
    }

}
