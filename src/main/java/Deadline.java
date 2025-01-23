public class Deadline extends Task {
    private String endDate;
    public Deadline(String name, String endDate) {
        super(name);
        this.endDate = endDate;
    }

    @Override
    public String getDetails() {
        String marking = status ? "X" : " ";
        return "[D][" + marking + "] " + name + "(by:"+ endDate + ")";
    }
}
