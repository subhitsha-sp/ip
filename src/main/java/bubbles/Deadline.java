package bubbles;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a deadline in the Bubbles chatbot.
 * A {@code Deadline} task includes a description and a due date and time.
 */
public class Deadline extends Task{
    protected String by;
    protected String task;

    /**
     * Constructs a {@code Deadline} task from the given description.
     * The description contains "/by" to separate the task
     * description from the deadline.
     *
     * @param description the full user input
     * @throws BubblesException if the task description is missing or improperly formatted
     */
    public Deadline(String description) throws BubblesException{
        super(description);
        String[] words = description.split("/by");
        this.task = words[0];

        if(this.task.trim().isEmpty()){
            throw new BubblesException("Woops! You forgot to add the description!");
        }
        this.by = words[1].trim();
    }

    /**
     * Returns a string representation of the deadline task.
     *
     * @return a string representing the deadline task
     */
    @Override
    public String toString(){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dt = LocalDateTime.parse(this.by, inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
        return "\t[D]" + this.getStatusIcon() + " " + this.task + "(by: " +  dt.format(outputFormatter) + ")";
    }
}
