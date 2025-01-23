public class Task {
    private String name;
    private boolean status;

    public Task(String name) {
        this.name = name;
        this.status = false;
    }
    public String getName() {
        return this.name;
    }
    public void unmarkStatus() {
        this.status = false;
    }

    public void markStatus() {
        this.status = true;
    }
    public String getDetails() {
        String marking = status ? "X" : " ";
        return "[" + marking + "] " + name;
    }
}
