package bubbles;

import java.io.IOException;

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
            Storage.append(deadline.toString() + "\n");
        } catch(BubblesException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println("Error : Something went wrong!");
        }
    }
}
