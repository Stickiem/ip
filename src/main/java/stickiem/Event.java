package stickiem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents task with time period.
 */
public class Event extends Task {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Event(String name, String startDate, String endDate, boolean status) {
        super(name, status);
        startDate = startDate.trim();
        endDate = endDate.trim();
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    @Override
    public String getDetails() {
        String marking = this.isDone ? "X" : " ";
        return "[E][" + marking + "] " + this.name + "(from: "
                + this.startDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))
                + " to: " + this.endDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    @Override
    public String getType() {
        return "event";
    }

    @Override
    public String getCommand() {
        String marking = isDone ? "X" : "";
        return marking + " " + this.getType() + " " + name + "/from " + startDate + " /to " + endDate;
    }
}
