package bubbles;

public class ByeCommand extends Command{
    private String command;

    public ByeCommand(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showExit();
    }
}

