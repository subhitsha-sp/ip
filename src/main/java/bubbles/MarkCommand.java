package bubbles;

import java.io.IOException;

public class MarkCommand extends Command {
    private String command;

    public MarkCommand(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        String[] words = command.split(" ");
        Task task = tasks.get(Integer.parseInt(words[1]) - 1);

        if (task.getStatusIcon().equals("[X]")) {
            System.out.println("Ayyyy! This task is already marked! 😅");
        } else {
            try {
                task.setDone();
                ui.showMarked(task);

                Storage.write(tasks.get(0).toString() + "\n");

                for (int i = 1; i < tasks.size(); i++) {
                    Task write_task = tasks.get(i);
//                    System.out.println(write_task);
                    Storage.append(write_task.toString() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Error : Something went wrong!");
            }
        }
    }
}