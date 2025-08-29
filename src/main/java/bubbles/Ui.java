package bubbles;

import java.util.ArrayList;

public class Ui {
    public Ui(){

    }

    public void showWelcome(){
        System.out.println("Hello! I'm bubbles.Bubbles 🫧 \nWhat can I do for you?");
    }

    public void showExit(){
        System.out.println("Byeee 👋");
    }

    public void showTaskList(ArrayList<Task> list){
        System.out.println("Here are the tasks in your list: ");
        for (int i = 0; i < list.size(); i++) {
            Task task = list.get(i);
            System.out.println("\t" + (i + 1) + "." + task.toString());
        }
    }

    public void showDelete(Task task, int numTasks){
        System.out.println("Poof! The task has drifted off from your list!");
        System.out.println(task);
        System.out.println("Juss " + numTasks + " more tasks waiting to drift away!");

    }

    public void showBubblesException(BubblesException e) {
        System.out.println(e.getMessage());
    }

    public void showMarked(Task task){
        System.out.println("Yayyy! Let's pop this task off 🥳");
        System.out.println(task);
    }

    public void showUnmarked(Task task){
        System.out.println("Okieee! Let's bubble it back in!");
        System.out.println(task);
    }

//    public void showAdd(Task task, int numTasks){
//        System.out.println("New bubble added to your list 📃");
//        System.out.println(task.toString());
//        System.out.println("Wohoo! You've got " + numTasks + " sparkly tasks floating in your list! ✨");
//    }

    public String showAdd(Task task, int numTasks){
        return "New bubble added to your list 📃" + "\n" + task + "\n" + "Wohoo! You've got " + numTasks + " sparkly tasks floating in your list! ✨";
    }

    public void showLine(){
        String line = "--------------------------------------------------------";
        System.out.println(line);
    }
}
