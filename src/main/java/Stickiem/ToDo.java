package Stickiem;

public class ToDo extends Task {

    public ToDo(String name, boolean status) {
        super(name, status);
    }

    @Override
    public String getDetails() {
        String marking = isDone ? "X" : " ";
        return "[T][" + marking + "] " + name;
    }

    @Override
    public String getType() {
        return "todo";
    }

    @Override
    public String getCommand() {
        String marking = isDone ? "X" : "";
        return marking + " " + this.getType() + " " + name;
    }
}
