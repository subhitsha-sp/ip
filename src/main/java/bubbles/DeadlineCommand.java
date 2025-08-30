package bubbles;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeadlineCommand extends Command {
    private String command;
    public DeadlineCommand (String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            if(!command.contains("/by")){
                throw new BubblesException("Woops! You forgot to add the deadline!");
            }
            String[] words = command.split("deadline", 2);
            Deadline deadline = new Deadline(words[1].trim());
            tasks.add(deadline);

            System.out.println(ui.showAdd(deadline, tasks.size()));

            String body = deadline.toString().split("] ")[1];
            String description = body.split("\\(by")[0].trim();
            String rawDate = body.substring(body.indexOf("(by:") + 5, body.length() - 1).trim();

            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            LocalDateTime dateTime = LocalDateTime.parse(rawDate, inputFormat);

            DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String by = dateTime.format(outputFormat);


            Storage.append("\t[D][ ] " + description + " " + "(by: " + by + ")" + "\n");
        } catch(BubblesException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println("Error : Something went wrong!");
        }
    }
}
