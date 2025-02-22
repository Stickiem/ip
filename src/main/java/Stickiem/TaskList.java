package stickiem;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList() {

        this.tasks = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> tasks) {

        this.tasks = tasks;
    }

    public String addTask(Task task) {
        this.tasks.add(task);

        String output = "Got it. I've added this task: \n" + task.getDetails();
        output += "\nNow you have " + this.tasks.size() + " tasks in the list.";

        return output;
    }

    public String removeTask(int index) {
        Task task = this.tasks.get(index);
        String output = "Noted. I've removed this task:" + task.getDetails();
        this.tasks.remove(index);
        return output;
    }

    public String getUnmarked() {
        int len = tasks.size();

        String output = "";
        for (int i = 0; i < len; i++) {
            int index = i + 1;
            Task currentTask = tasks.get(i);
            if(currentTask.getMarkStatus() == false) {
                output += "\n" + index + "." + currentTask.getDetails();
            }

        }
        return output;
    }

    public String getTaskDetails() {
        int len = tasks.size();

        String output = "";
        for (int i = 0; i < len; i++) {
            int index = i + 1;
            Task currentTask = tasks.get(i);
            output += "\n" + index + "." + currentTask.getDetails();

        }

        return output;
    }

    public Task getTask(int index) {

        return this.tasks.get(index);
    }

    public ArrayList<Task> getTasks(String keyword) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        for(Task task : this.tasks) {
            if(task.getName().contains(keyword)) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    public ArrayList<String> convertCommand() {
        ArrayList<String> commands = new ArrayList<String>();
        for(int i = 0; i < this.tasks.size(); i++) {
            commands.add(this.tasks.get(i).getCommand());
        }
        return commands;
    }
}
