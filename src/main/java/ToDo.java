public class ToDo extends Task {

    public ToDo(String name) {
        super(name);
    }

    @Override
    public String getDetails() {
        String marking = status ? "X" : " ";
        return "[T][" + marking + "] " + name;
    }

    @Override
    public String getType() {
        return "todo";
    }
}
