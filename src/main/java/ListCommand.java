public class ListCommand extends Command{
    private String command;

    public ListCommand(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks.getAll());
    }
}
