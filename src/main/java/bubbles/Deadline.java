package bubbles;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    protected String by;
    protected String task;

    public Deadline(String description) throws BubblesException{
        super(description);
        String[] words = description.split("/by");
        this.task = words[0];

        if(this.task.trim().isEmpty()){
            throw new BubblesException("Woops! You forgot to add the description!");
        }
        this.by = words[1].trim();
    }

    @Override
    public String toString(){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dt = LocalDateTime.parse(this.by, inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
        return "\t[D]" + this.getStatusIcon() + " " + this.task + "(by: " +  dt.format(outputFormatter) + ")";
    }
}
