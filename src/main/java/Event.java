public class Event extends Task {
    private String startDate;
    private String endDate;

    private String deadline;
    public Event(String name, String startDate, String endDate) {
        super(name);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String getDetails() {
        String marking = status ? "X" : " ";
        return "[E][" + marking + "] " + name + "(from:"+ startDate + "to:" + endDate + ")";
    }
}
