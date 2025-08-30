package bubbles;

/**
 * Represents a command to find a task based on a keyword in the task description
 */
public class FindCommand extends Command{
    private String command;
    private String word;

    /**
     * Constructs a {@code FindCommand} with the given command string.
     * This command searches for tasks which contains the given keyword
     * and displays it.
     *
     * @param command the user input for the keyword
     */
    public FindCommand(String command) {
        super(command);
        this.command = command;
        this.word = command.substring(5).trim();
    }

    /**
     * Executes the find command which extracts the keyword from the command
     * and searches for tasks which contains the keyword in the task description
     * and displays them.
     *
     * @param tasks List of all the tasks.
     * @param ui The UI.
     * @param storage The list of tasks stored in the hard disk.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        int i = 1;
        int count = 0;

        for(Task task: tasks.getAll()) {
            String str = task.toString();

            if (str.substring(7).trim().contains(this.word)) {
                count++;
            }
        }

        if (count > 0) {
            System.out.println("Here are the bubbles that match: ");
        } else {
            System.out.println("Uh-oh! Not found in my bubble land!");
        }

        for(Task task: tasks.getAll()){
            String str = task.toString();

            if (str.substring(7).trim().contains(this.word)) {
                System.out.println("\t" + Integer.toString(i) + "." + task);
                i ++;
            }
        }
    }
}
