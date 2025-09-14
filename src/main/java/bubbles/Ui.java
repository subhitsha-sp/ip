package bubbles;

import java.util.ArrayList;

/**
 * Responsible for handling all user interface interactions for the Bubbles chatbot.
 */
public class Ui{
    /**
     * Displays the welcome message when the chatbot starts.
     */
    public String showWelcome(){
        return "Hello! I'm Bubbles! \nWhat can I do for you?";
    }

    /**
     * Displays the exit message when the user leaves.
     */
    public String showExit(){
        return "Byeee! ";
    }

    /**
     * Displays the list of all the current tasks.
     *
     * @param list the list which contains all the current tasks
     */
    public String showTaskList(ArrayList<Task> list){
//        System.out.println("Here are the tasks in your list: ");
//        for (int i = 0; i < list.size(); i++) {
//            Task task = list.get(i);
//            System.out.println("\t" + (i + 1) + "." + task.toString());
//        }

        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append("\t").append(i + 1).append(". ").append(list.get(i)).append("\n");
        }
        return sb.toString().trim();

    }

    /**
     * Displays the task that was just deleted and the number of remaining
     * tasks in the list.
     *
     * @param task the task to be deleted
     * @param numTasks the number of tasks currently in the list
     */
    public String showDelete(Task task, int numTasks){
        return "Poof! The task has drifted off from your list!\n" + task + "\nJuss " + numTasks + " more tasks waiting to drift away!";
    }


/**
 * Displays the error message from a {@code BubblesException}.
 *
 * @param e the exception to be displayed
 */
public String showBubblesException(BubblesException e) {
    return e.getMessage();
}

/**
 * Displays the message which was just marked as completed.
 *
 * @param task the task that was marked
 */
public String showMarked(Task task){
    return "Yayyy! Let's pop this task off! \n" + task;

}

/**
 * Displays the message which was just unmarked.
 *
 * @param task the task that was unmarked
 */
public String showUnmarked(Task task){
    return "Okieee! Let's bubble it back in!\n" + task;
}

/**
 * Displays the task that was just added to the list
 * and the number of remaining tasks in the list.
 *
 * @param task the task to be added
 * @param numTasks the number of tasks currently in the list
 */
public String showAdd(Task task, int numTasks){
    return "New bubble added to your list! " + "\n" + task + "\n" + "Wohoo! You've got " + numTasks + " sparkly tasks floating in your list!";
}

/**
 * Displays a horizontal line as a separator.
 */
public String showLine(){
    String line = "--------------------------------------------------------";
    return line;
}
}
