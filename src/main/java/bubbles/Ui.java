package bubbles;

import java.util.ArrayList;

/**
 * Responsible for handling all user interface interactions for the Bubbles chatbot.
 */
public class Ui {
    /**
     * Displays the welcome message when the chatbot starts.
     */
    public void showWelcome(){
        System.out.println("Hello! I'm bubbles.Bubbles 🫧 \nWhat can I do for you?");
    }

    /**
     * Displays the exit message when the user leaves.
     */
    public void showExit(){
        System.out.println("Byeee 👋");
    }

    /**
     * Displays the list of all the current tasks.
     *
     * @param list the list which contains all the current tasks
     */
    public void showTaskList(ArrayList<Task> list){
        System.out.println("Here are the tasks in your list: ");
        for (int i = 0; i < list.size(); i++) {
            Task task = list.get(i);
            System.out.println("\t" + (i + 1) + "." + task.toString());
        }
    }

    /**
     * Displays the task that was just deleted and the number of remaining
     * tasks in the list.
     *
     * @param task the task to be deleted
     * @param numTasks the number of tasks currently in the list
     */
    public void showDelete(Task task, int numTasks){
        System.out.println("Poof! The task has drifted off from your list!");
        System.out.println(task);
        System.out.println("Juss " + numTasks + " more tasks waiting to drift away!");
    }

    /**
     * Displays the error message from a {@code BubblesException}.
     *
     * @param e the exception to be displayed
     */
    public void showBubblesException(BubblesException e) {
        System.out.println(e.getMessage());
    }

    /**
     * Displays the message which was just marked as completed.
     *
     * @param task the task that was marked
     */
    public void showMarked(Task task){
        System.out.println("Yayyy! Let's pop this task off 🥳");
        System.out.println(task);
    }

    /**
     * Displays the message which was just unmarked.
     *
     * @param task the task that was unmarked
     */
    public void showUnmarked(Task task){
        System.out.println("Okieee! Let's bubble it back in!");
        System.out.println(task);
    }

    /**
     * Displays the task that was just added to the list
     * and the number of remaining tasks in the list.
     *
     * @param task the task to be added
     * @param numTasks the number of tasks currently in the list
     */
    public String showAdd(Task task, int numTasks){
        return "New bubble added to your list 📃" + "\n" + task + "\n" + "Wohoo! You've got " + numTasks + " sparkly tasks floating in your list! ✨";
    }

    /**
     * Displays a horizontal line as a separator.
     */
    public void showLine(){
        String line = "--------------------------------------------------------";
        System.out.println(line);
    }
}
