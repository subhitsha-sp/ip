package bubbles;

import java.io.IOException;

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
            Storage.append(event.toString() + "\n");

        } catch (IOException e){
            System.out.println("Error : Something went wrong!");
        } catch (BubblesException e){
            System.out.println(e.getMessage());
        }
    }
}
