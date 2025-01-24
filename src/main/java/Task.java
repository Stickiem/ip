public class Task {
    public String name;
    public boolean status;

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

    public String getType() {
        return null;
    }
}
