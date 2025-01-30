public class Task {
    public String name;
    public boolean isDone;

    public Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }
    public String getName() {
        return this.name;
    }
    public void unmarkStatus() {
        this.isDone = false;
    }

    public void markStatus() {
        this.isDone = true;
    }
    public String getDetails() {
        String marking = isDone ? "X" : " ";
        return "[" + marking + "] " + name;
    }

    public String getType() {
        return null;
    }

    public String getCommand() {
        return null;
    }
}
