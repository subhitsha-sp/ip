package bubbles;

import java.io.FileWriter;
import java.io.IOException;

public class TodoCommand extends Command {
    private String command;
    public TodoCommand (String command) {
        super(command);
        this.command = command;
    }

@Override
public void execute(TaskList tasks, Ui ui, Storage storage) {
    try {
        String[] words = this.command.split("todo", 2);
        if (words.length < 2 || words[1].isEmpty()) {
            throw new BubblesException("Oopsies! You forgot to give me the description 🤭");
        }
        Todo todo = new Todo(words[1].trim());
        tasks.add(todo);
        ui.showAdd(todo, tasks.size());
        Storage.append(todo.toString() + "\n");

    } catch (BubblesException e) {
        System.out.println(e.getMessage());
    }
    catch (IOException e){
        System.out.println("Error : Something went wrong!");
    }
    }
}

