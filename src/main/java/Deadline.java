public class Deadline extends Task {
    private String endDate;
    public Deadline(String name, String endDate, boolean status) {
        super(name, status);
        this.endDate = endDate;
    }

    @Override
    public String getDetails() {
        String marking = status ? "X" : " ";
        return "[D][" + marking + "] " + name + "(by:"+ endDate + ")";
    }

    @Override
    public String getType() {
        return "deadline";
    }

    @Override
    public String getCommand() {
        String marking = status ? "X" : "";
        return marking + " " + this.getType() + " " + name + "/by" + endDate;
    }

}
