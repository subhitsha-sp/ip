package bubbles;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventCommand extends Command{
    private String command;
    public EventCommand (String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            String[] words = command.split("event", 2);
            Event event = new Event(words[1].trim());
            tasks.add(event);
            System.out.println(ui.showAdd(event, tasks.size()));

            String body = event.toString().split("] ")[1];
            String description = body.split("\\(from")[0].trim();
            String rawFrom = body.split("\\(from: ")[1].trim().split("to:")[0].trim();
            String rawTo = body.substring(body.indexOf("to:") + 4, body.length() - 1).trim();

            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
            LocalDateTime fromTime = LocalDateTime.parse(rawFrom, inputFormat);
            LocalDateTime toTime = LocalDateTime.parse(rawTo, inputFormat);

            DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String from = fromTime.format(outputFormat);
            String to = toTime.format(outputFormat);

            Storage.append("\t[E][ ] " + description + " " + "(from: " + from + " to: " + to+ ")" + "\n");

        } catch (IOException e){
            System.out.println("Error : Something went wrong!");
        } catch (BubblesException e){
            System.out.println(e.getMessage());
        }
    }
}
