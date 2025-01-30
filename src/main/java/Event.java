public class Event extends Task {
    private String startDate;
    private String endDate;

    private String deadline;
    public Event(String name, String startDate, String endDate, boolean status) {
        super(name, status);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String getDetails() {
        String marking = status ? "X" : " ";
        return "[E][" + marking + "] " + name + "(from:"+ startDate + "to:" + endDate + ")";
    }

    @Override
    public String getType() {
        return "event";
    }

    @Override
    public String getCommand() {
        String marking = status ? "X" : "";
        return marking + " " + this.getType() + " " + name + "/from" + startDate + "/to" + endDate;
    }
}
