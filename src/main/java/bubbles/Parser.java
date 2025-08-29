package bubbles;

import java.io.IOException;

public class Parser {
    public static Command parse(String command) throws BubblesException {
        command = command.trim().toLowerCase();
        if (command.startsWith("todo")) {
            return new TodoCommand(command);
        }

        else if (command.startsWith("deadline")) {
            return new DeadlineCommand(command);
        }

        else if (command.startsWith("event")) {
            return new EventCommand(command);
        }

        else if (command.startsWith("mark")) {
            return new MarkCommand(command);
        }

        else if (command.startsWith("unmark")) {
            return new UnmarkCommand(command);
        }

        else if (command.startsWith("delete")) {
            return new DeleteCommand(command);
        }

        else if (command.equals("list")) {
            return new ListCommand(command);
        }

        else {
            throw new BubblesException("Sawwryy... that one bounced right off my bubblehead! I don't understand it yet 🥺");
        }


    }
}
