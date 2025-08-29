import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(){
        this.tasks = new ArrayList<>();
    }
    public TaskList(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    public void add(Task task){
        tasks.add(task);
    }

    public void remove(int index){
        tasks.remove(index);
    }

    public int size(){
        return tasks.size();
    }

    public Task get(int index){
        return tasks.get(index);
    }

    public boolean isEmpty(){
        return tasks.isEmpty();
    }

    public ArrayList<Task> getAll(){
        return this.tasks;
    }
}
