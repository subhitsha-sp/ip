package bubbles;

import java.io.IOException;

public class DeleteCommand extends Command{
    private String command;

    public DeleteCommand(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try{
            String[] words = command.split(" ");
            Task task = tasks.get(Integer.parseInt(words[1]) - 1);
            tasks.remove(Integer.parseInt(words[1]) - 1);
            ui.showDelete(task, tasks.size());

            if(!tasks.isEmpty()) {
                Storage.write(tasks.get(0).toString() + "\n");

                for (int i = 1; i < tasks.size(); i++) {
                    Task write_task = tasks.get(i);
                    Storage.append(write_task.toString() + "\n");
                }
            }

        } catch (IOException e){
                System.out.println("Error : Something went wrong!");
            }
    }
}
